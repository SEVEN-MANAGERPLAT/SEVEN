package com.seven.aemp.dao;

import com.seven.aemp.bean.SystemAccountBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mwl
 * @since 2020-03-31
 */
public interface SystemAccountDao extends BaseMapper<SystemAccountBean> {


    //查询账户
    public List<SystemAccountBean> querySystemAccount(SystemAccountBean systemAccountBean);

    //修改账户信息
    public int updateSystemAccount(SystemAccountBean systemAccountBean);
}
