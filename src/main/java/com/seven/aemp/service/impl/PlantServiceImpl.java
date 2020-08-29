package com.seven.aemp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seven.aemp.bean.PlantBean;
import com.seven.aemp.dao.PlantDao;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.service.AccountService;
import com.seven.aemp.service.PlantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seven.aemp.util.TimeUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author mwl
 * @since 2019-11-19
 */
@Service
public class PlantServiceImpl extends ServiceImpl<PlantDao, PlantBean> implements PlantService {

    @Autowired
    private PlantDao plantDao;

    @Autowired
    private AccountService accountService;

    @Override
    public List<PlantBean> queryPlant(PlantBean plantBean) throws Exception {
        return plantDao.queryPlant(plantBean);
    }

    @Override
    public Page<PlantBean> queryPlant(String page, String pageSize, PlantBean plantBean) throws Exception {
        if (StringUtils.isBlank(page)) {
            page = "1";
        }
        if (StringUtils.isBlank(pageSize)) {
            pageSize = "10";
        }
        Page<PlantBean> result = new Page<>(Long.valueOf(page), Long.valueOf(pageSize));
        return result.setRecords(plantDao.queryPlant(result, plantBean));
    }

    @Override
    public void addPlant(PlantBean plantBean) throws MessageException {
        if (StringUtils.isBlank(plantBean.getPlanName())) throw new MessageException("计划名称不能为空");
        if (StringUtils.isBlank(plantBean.getPlanPredict())) throw new MessageException("预算不能为空");
        if (StringUtils.isBlank(plantBean.getAccId())) throw new MessageException("登录账号已过期，请重新登录");
        QueryWrapper<PlantBean> queryWrapper = new QueryWrapper<PlantBean>();
        queryWrapper.select("*");
        queryWrapper.eq("PLAN_NAME", plantBean.getPlanName());
        List<PlantBean> plantBeans = plantDao.selectList(queryWrapper);
        if (plantBeans.size() > 0) throw new MessageException("计划名不能重复!");
        if (plantDao.insert(plantBean) <= 0) throw new MessageException("操作失败!");
    }

    @Override
    public void updatePlant(PlantBean plantBean) throws MessageException {
        QueryWrapper<PlantBean> queryWrapper = new QueryWrapper<PlantBean>();
        queryWrapper.select("*");
        queryWrapper.ne("plan_id", plantBean.getPlanId());
        List<PlantBean> plantBeans = plantDao.selectList(queryWrapper);
        if (plantBeans.size() > 0) throw new MessageException("计划名不能重复!");
        if (plantDao.updateById(plantBean) <= 0) throw new MessageException("操作失败!");
    }

    @Override
    public IPage queryPlantBackReport(PlantBean plantBean) throws Exception {
        Page page = new Page();
        page.setCurrent(StringUtils.isBlank(plantBean.getPage()) ? 1L : Long.valueOf(plantBean.getPage()));
        page.setSize(StringUtils.isBlank(plantBean.getPageSize()) ? 10L : Long.valueOf(plantBean.getPageSize()));
        if (StringUtils.isNotBlank(plantBean.getEndDate()))
            plantBean.setEndDate(TimeUtil.getDateYYYY_MM_DD_HH_MM_SS(TimeUtil.dateAdd(TimeUtil.parseAnyDate(plantBean.getEndDate()), TimeUtil.UNIT_DAY, 1)));
        return plantDao.queryPlantBackReport(page, plantBean);
    }

    @Override
    public Page<PlantBean> queryPlanClickNum(String page, String pageSize, PlantBean plantBean) throws Exception {
        System.out.println(accountService.getCurrentAccount());
        if (StringUtils.isBlank(page)) {
            page = "1";
        }
        if (StringUtils.isBlank(pageSize)) {
            pageSize = "10";
        }
        Page<PlantBean> result = new Page<>(Long.valueOf(page), Long.valueOf(pageSize));
        return result.setRecords(plantDao.queryPlanClickNum(result, plantBean));
    }
}
