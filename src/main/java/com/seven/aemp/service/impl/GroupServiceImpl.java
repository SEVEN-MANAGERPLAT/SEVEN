package com.seven.aemp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seven.aemp.bean.GroupBean;
import com.seven.aemp.dao.GroupDao;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.service.GroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mwl
 * @since 2019-11-19
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupDao, GroupBean> implements GroupService {

    @Autowired
    GroupDao groupDao;

    @Override
    public List<GroupBean> queryGroup(GroupBean groupBean) throws MessageException {
        return groupDao.queryGroup(groupBean);
    }

    @Override
    public void addGroup(GroupBean groupBean) throws MessageException {
        QueryWrapper<GroupBean> queryWrapper = new QueryWrapper<GroupBean>();
        queryWrapper.select("*");
        queryWrapper.eq(true, "eg_name", groupBean.getEgName());
        queryWrapper.ne("eg_id", groupBean.getEgName());
        List<GroupBean> groupBeans = groupDao.selectList(queryWrapper);
        if(groupBeans.size() > 0)throw new MessageException("组名不能重复!");
        if (groupDao.insert(groupBean) <= 0) throw new MessageException("操作失败!");
    }

    @Override
    public void updateGroup(GroupBean groupBean) throws MessageException {
        QueryWrapper<GroupBean> queryWrapper = new QueryWrapper<GroupBean>();
        queryWrapper.select("*");
        queryWrapper.eq(true, "eg_name", groupBean.getEgName());
        queryWrapper.ne("eg_id", groupBean.getEgId());
        List<GroupBean> groupBeans = groupDao.selectList(queryWrapper);
        if(groupBeans.size() > 0)throw new MessageException("组名不能重复!");
        if (groupDao.updateById(groupBean) <= 0) throw new MessageException("操作失败!");
    }
}
