package com.seven.aemp.service;

import com.alibaba.fastjson.JSONObject;
import com.seven.aemp.bean.AccountBean;
import com.seven.aemp.bean.SystemAccountBean;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mwl
 * @since 2020-03-31
 */
public interface SystemAccountService extends IService<SystemAccountBean> {

    //查询系统账户
    public List<SystemAccountBean> querySystemAccount(SystemAccountBean systemAccountBean);

    //系统账户登录
    public JSONObject login(SystemAccountBean systemAccountBean) throws Exception;

    //修改系统信息
    public void updateSystemAccount(SystemAccountBean systemAccountBean)throws Exception;

    //添加系统账户
    public SystemAccountBean addSystemAccount(SystemAccountBean systemAccountBean) throws Exception;
}
