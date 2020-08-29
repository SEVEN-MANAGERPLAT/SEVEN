package com.seven.aemp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seven.aemp.bean.IdeaBean;
import com.seven.aemp.bean.IdeaclickBean;
import com.seven.aemp.dao.IdeaDao;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.service.AccountService;
import com.seven.aemp.service.IdeaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seven.aemp.service.IdeaclickService;
import com.seven.aemp.util.TimeUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author mwl
 * @since 2019-11-19
 */
@Service
public class IdeaServiceImpl extends ServiceImpl<IdeaDao, IdeaBean> implements IdeaService {

    @Value("${baseUrl}")
    private String baseUrl;

    @Autowired
    private IdeaDao ideaDao;

    @Autowired
    private IdeaclickService ideaclickService;

    @Autowired
    private AccountService accountService;

    @Override
    public List<IdeaBean> queryIdea(IdeaBean ideaBean) throws Exception {
        return ideaDao.queryIdea(ideaBean);
    }

    @Override
    public Page<IdeaBean> queryIdea(String page, String pageSize, IdeaBean ideaBean) throws Exception {
        if (StringUtils.isBlank(page)) {
            page = "1";
        }
        if (StringUtils.isBlank(pageSize)) {
            pageSize = "10";
        }
        Page<IdeaBean> result = new Page<>(Long.valueOf(page), Long.valueOf(pageSize));
        return result.setRecords(ideaDao.queryIdea(result, ideaBean));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addIdea(IdeaBean ideaBean, MultipartFile[] file) throws Exception {
        QueryWrapper<IdeaBean> queryWrapper = new QueryWrapper<IdeaBean>();
        queryWrapper.select("*");
        queryWrapper.eq("PLAN_ID", ideaBean.getPlanId());
        queryWrapper.eq("EG_ID", ideaBean.getEgId());
        queryWrapper.eq("IDEA_NAME", ideaBean.getIdeaName());
        List<IdeaBean> ideaBeans = ideaDao.selectList(queryWrapper);
        if (ideaBeans.size() > 0) throw new MessageException("创意名不能重复!");

        String newDate = TimeUtil.getDateYYYYMMDD(TimeUtil.getDBTime());
        ideaBean.setCreateDate(newDate);
        //设置点击率
        Random random = new Random();
        int s = random.nextInt(20) % (5) + 15;
        ideaBean.setClickRate(String.valueOf(s));
        ideaBean.setCheckState("2");
        if (ideaDao.addIdea(ideaBean) <= 0) throw new MessageException("操作失败!");

        //生成创意ID
        ideaBean.setProdUrl(ideaBean.getPlanId().concat("idea".concat(ideaBean.getPlanId()).concat(ideaBean.getIdeaId())));
        this.updateIdea(ideaBean);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateIdea(IdeaBean ideaBean) throws Exception {
        QueryWrapper<IdeaBean> queryWrapper = new QueryWrapper<IdeaBean>();
        queryWrapper.select("*");
        queryWrapper.eq("IDEA_ID", ideaBean.getIdeaId());
        List<IdeaBean> ideaBeans = ideaDao.selectList(queryWrapper);
        if (ideaBeans.size() <= 0) throw new MessageException("创意不存在!");
        if (ideaDao.updateById(ideaBean) <= 0) throw new MessageException("操作失败!");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public IdeaBean updateCilckIdea(IdeaBean ideaBean) throws Exception {
        QueryWrapper<IdeaBean> queryWrapper = new QueryWrapper<IdeaBean>();
        queryWrapper.select("*");
        queryWrapper.eq("PROD_URL", ideaBean.getProdUrl());
        List<IdeaBean> ideaBeans = ideaDao.selectList(queryWrapper);
        if (ideaBeans.size() <= 0) throw new MessageException("创意不存在!");

        String newDate = TimeUtil.getDateYYYY_MM_DD(TimeUtil.getDBTime());
        ideaBean.setCreateDate(newDate);
        //查询当日的创意点击
        List<IdeaclickBean> ideaclickBeans = ideaclickService.queryIdeaclick(new IdeaclickBean().setIdeaId(ideaBeans.get(0).getIdeaId()).setIdeaDate(newDate));
        if (ideaclickBeans.isEmpty()) {
            ideaclickService.addIdeaclick(new IdeaclickBean().setIdeaId(ideaBeans.get(0).getIdeaId()).setIdeaDate(newDate).setClickNum("1"));
        } else {
            ideaclickService.updateIdeaclick(new IdeaclickBean().setIcId(ideaclickBeans.get(0).getIcId()).setClickNum(String.valueOf(Integer.valueOf(ideaclickBeans.get(0).getClickNum()) + 1)));
        }
        return ideaBeans.get(0);
    }

    @Override
    public void updateCheckState(IdeaBean ideaBean) throws Exception {
        ideaDao.updateCheckState(ideaBean);
    }

    @Override
    public Page<IdeaBean> queryIdeaClickByUnitDay(String page, String pageSize, IdeaBean ideaBean) throws Exception {
        if (StringUtils.isBlank(page)) {
            page = "1";
        }
        if (StringUtils.isBlank(pageSize)) {
            pageSize = "10";
        }
        Page<IdeaBean> result = new Page<>(Long.valueOf(page), Long.valueOf(pageSize));
        return result.setRecords(ideaDao.queryIdeaClickByUnitDay(result, ideaBean.setAccId(String.valueOf(accountService.getCurrentAccount().getAccountId()))));
    }

    @Override
    public IPage queryIdeaBackReport(IdeaBean ideaBean) throws Exception {
        Page page = new Page();
        page.setCurrent(StringUtils.isBlank(ideaBean.getPage()) ? 1L : Long.valueOf(ideaBean.getPage()));
        page.setSize(StringUtils.isBlank(ideaBean.getPageSize()) ? 10L : Long.valueOf(ideaBean.getPageSize()));
        if (StringUtils.isNotBlank(ideaBean.getEndDate()))
            ideaBean.setEndDate(TimeUtil.getDateYYYY_MM_DD_HH_MM_SS(TimeUtil.dateAdd(TimeUtil.parseAnyDate(ideaBean.getEndDate()), TimeUtil.UNIT_DAY, 1)));
        return ideaDao.queryIdeaBackReport(page, ideaBean);
    }

    //保存文件
    private void saveFile(IdeaBean ideaBean, MultipartFile[] file) throws Exception {
        if (file != null) {
            for (MultipartFile multipartFile : file) {
                //原文件名
                String fileName = multipartFile.getOriginalFilename();
                fileName = fileName.substring(fileName.lastIndexOf("."));

                System.out.println("introduce" + ideaBean.toString());
                File directory = new File("");// 参数为空
                String path = directory.getCanonicalPath();
                String imgName = ("img_").concat(ideaBean.getIdeaId().toString()).concat(fileName);
                File dir = new File(path);
                if (!dir.exists()) dir.mkdirs();
                path = path.concat("/webapps/img/evaluation/").concat(imgName);
                System.out.println("路径：" + path);
                ideaBean.setUpdateUrl(baseUrl.concat("img/evaluation/").concat(imgName));
                System.out.println("introduce" + ideaBean.toString());
                this.updateIdea(ideaBean);

                //读写文件
                if (!multipartFile.isEmpty()) {
                    InputStream is = multipartFile.getInputStream();
                    int len = 0;
                    byte[] by = new byte[1024];
                    OutputStream os = new FileOutputStream(path);
                    BufferedInputStream bis = new BufferedInputStream(is);
                    BufferedOutputStream bos = new BufferedOutputStream(os);
                    while ((len = bis.read(by)) != -1) {
                        bos.write(by, 0, len);
                        bos.flush();
                    }
                    if (bos != null)
                        bos.close();
                    if (bis != null)
                        bis.close();
                    if (os != null)
                        os.close();
                    if (is != null)
                        is.close();
                }
            }
        }
    }


}
