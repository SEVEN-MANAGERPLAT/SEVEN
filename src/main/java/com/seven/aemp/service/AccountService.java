package com.seven.aemp.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seven.aemp.bean.AccountBean;
import com.baomidou.mybatisplus.extension.service.IService;
import com.seven.aemp.bean.GroupBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mwl
 * @since 2019-11-19
 */
public interface AccountService extends IService<AccountBean> {
    //查询用户
    public List<AccountBean> queryAccount(AccountBean accountBean);

    public Page<AccountBean> queryAccount(String page, String pageSize, AccountBean accountBean) throws Exception;

    //用户登录
    public JSONObject login(AccountBean accountBean) throws Exception;

    //修改用户信息
    public void updateAccount(AccountBean accountBean)throws Exception;

    //添加账户
    public AccountBean addAccount(AccountBean accountBean) throws Exception;

    UserDetails loadUserByUsername(String userName);

    public JSONObject loginTwo(AccountBean accountBean)throws Exception;
}
