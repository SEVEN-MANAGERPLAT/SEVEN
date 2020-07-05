package com.seven.aemp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seven.aemp.bean.GroupBean;
import com.baomidou.mybatisplus.extension.service.IService;
import com.seven.aemp.exception.MessageException;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mwl
 * @since 2019-11-19
 */
public interface GroupService extends IService<GroupBean> {

    //查询推广组
    public List<GroupBean> queryGroup(GroupBean groupBean)throws Exception;

    public Page<GroupBean> queryGroup(String page, String pageSize, GroupBean groupBean) throws Exception;

    //添加推广组
    public void addGroup(GroupBean groupBean)throws MessageException;

    //修改推广组
    public void updateGroup(GroupBean groupBean)throws MessageException;

}
