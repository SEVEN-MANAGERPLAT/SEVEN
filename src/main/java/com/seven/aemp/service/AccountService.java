package com.seven.aemp.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.seven.aemp.bean.AccountBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Map;

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

  //获取当前登录的用户信息
  public AccountBean getCurrentAccount();

  //查询充值信息
  public Map<String,String> queryConsumAndArrease() throws Exception;

  //查询不同状态的客户数
  public Map<String,String> queryAccountState() throws Exception;

  //查询每日的点击量，消费情况
  public List<Map<String,String>> queryConsum(AccountBean accountBean) throws Exception;

  //查询推广账户统计
  public List<AccountBean> queryFirmSummary(AccountBean accountBean) throws Exception;



  //前台接口
  //公共数据查询
  public JSONObject queryTotleData() throws Exception;

  //前台首页查询
  public Page<AccountBean> queryAccoutClickNum(String page, String pageSize, AccountBean accountBean) throws Exception;
}