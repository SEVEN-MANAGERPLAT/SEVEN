package com.seven.aemp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seven.aemp.bean.GroupBean;
import com.seven.aemp.dao.GroupDao;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.service.GroupService;
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
public class GroupServiceImpl extends ServiceImpl<GroupDao, GroupBean> implements GroupService {

    @Autowired
    GroupDao groupDao;

    @Override
    public List<GroupBean> queryGroup(GroupBean groupBean) throws Exception {
        return groupDao.queryGroup(groupBean);
    }

    @Override
    public Page<GroupBean> queryGroup(String page, String pageSize, GroupBean groupBean) throws Exception {
        if (StringUtils.isBlank(page)) {
            page = "1";
        }
        if (StringUtils.isBlank(pageSize)) {
            pageSize = "10";
        }
        Page<GroupBean> result = new Page<>(Long.valueOf(page), Long.valueOf(pageSize));
        return result.setRecords(groupDao.queryGroup(result, groupBean));
    }

    @Override
    public void addGroup(GroupBean groupBean) throws MessageException {
        QueryWrapper<GroupBean> queryWrapper = new QueryWrapper<GroupBean>();
        queryWrapper.select("*");
        queryWrapper.eq(true, "eg_name", groupBean.getEgName());
        queryWrapper.ne("eg_id", groupBean.getEgName());
        List<GroupBean> groupBeans = groupDao.selectList(queryWrapper);
        String newDate = TimeUtil.getDateYYYYMMDD(TimeUtil.getDBTime());
        groupBean.setCreateDate(newDate);
        if (groupBeans.size() > 0) throw new MessageException("组名不能重复!");
        if (groupDao.insertGroup(groupBean) <= 0) throw new MessageException("操作失败!");
    }

    @Override
    public void updateGroup(GroupBean groupBean) throws MessageException {
        QueryWrapper<GroupBean> queryWrapper = new QueryWrapper<GroupBean>();
        queryWrapper.select("*");
        queryWrapper.eq(true, "eg_name", groupBean.getEgName());
        queryWrapper.ne("eg_id", groupBean.getEgId());
        List<GroupBean> groupBeans = groupDao.selectList(queryWrapper);
        if (groupBeans.size() > 0) throw new MessageException("组名不能重复!");
        if (groupDao.updateById(groupBean) <= 0) throw new MessageException("操作失败!");
    }

    @Override
    public IPage queryGroupBackReport(GroupBean groupBean) throws Exception {
        Page page = new Page();
        page.setCurrent(StringUtils.isBlank(groupBean.getPage()) ? 1L : Long.valueOf(groupBean.getPage()));
        page.setSize(StringUtils.isBlank(groupBean.getPageSize()) ? 10L : Long.valueOf(groupBean.getPageSize()));
        if (StringUtils.isNotBlank(groupBean.getEndDate()))
            groupBean.setEndDate(TimeUtil.getDateYYYY_MM_DD_HH_MM_SS(TimeUtil.dateAdd(TimeUtil.parseAnyDate(groupBean.getEndDate()), TimeUtil.UNIT_DAY, 1)));
        return groupDao.queryGroupBackReport(page,groupBean);
    }

    @Override
    public Page<GroupBean> queryGroupIdeaClickByUnitDay(String page, String pageSize, GroupBean groupBean) throws Exception {
        if (StringUtils.isBlank(page)) {
            page = "1";
        }
        if (StringUtils.isBlank(pageSize)) {
            pageSize = "10";
        }
        Page<GroupBean> result = new Page<>(Long.valueOf(page), Long.valueOf(pageSize));
        return result.setRecords(groupDao.queryGroupIdeaClickByUnitDay(result, groupBean));
    }
}
