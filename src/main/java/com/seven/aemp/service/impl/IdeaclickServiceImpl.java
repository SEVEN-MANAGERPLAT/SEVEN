package com.seven.aemp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seven.aemp.bean.IdeaclickBean;
import com.seven.aemp.dao.IdeaclickDao;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.service.IdeaclickService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mwl
 * @since 2020-04-03
 */
@Service
public class IdeaclickServiceImpl extends ServiceImpl<IdeaclickDao, IdeaclickBean> implements IdeaclickService {

    @Autowired
    private IdeaclickDao ideaclickDao;

    @Override
    public List<IdeaclickBean> queryIdeaclick(IdeaclickBean ideaclickBean) throws Exception {
        return ideaclickDao.queryIdeaclick(ideaclickBean);
    }

    @Override
    public void addIdeaclick(IdeaclickBean ideaclickBean) throws Exception {
        if (StringUtils.isEmpty(ideaclickBean.getIdeaId())) throw new MessageException("创意不能为空");
        QueryWrapper<IdeaclickBean> queryWrapper = new QueryWrapper<IdeaclickBean>();
        queryWrapper.select("*");
        queryWrapper.eq("IDEA_ID", ideaclickBean.getIdeaId());
        queryWrapper.eq("IDEA_DATE", ideaclickBean.getIdeaDate());
        List<IdeaclickBean> ideaclickBeans = ideaclickDao.selectList(queryWrapper);
        if(ideaclickBeans.size() > 0) throw new MessageException("创意点击已经存在，无需重复添加！！！");
        if (ideaclickDao.insert(ideaclickBean) <= 0) throw new MessageException("操作失败!");
    }

    @Override
    public void updateIdeaclick(IdeaclickBean ideaclickBean) throws Exception {
        if (ideaclickBean.getIcId()<=0) throw new MessageException("创意点击不能为空");

        if (ideaclickDao.updateIdeaclick(ideaclickBean) <= 0) throw new MessageException("操作失败!");
    }
}
