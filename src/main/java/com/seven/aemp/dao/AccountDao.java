package com.seven.aemp.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seven.aemp.bean.AccountBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mwl
 * @since 2019-11-19
 */
public interface AccountDao extends BaseMapper<AccountBean> {
    //查询用户
    public List<AccountBean> queryAccount( @Param("account") AccountBean accountBean);

    //分页组查询
    List<AccountBean> queryAccount(Page<AccountBean> result, @Param("account") AccountBean accountBean);

    //修改用户信息
    int updateAccount(AccountBean accountBean);

    //账户剩余金额和昨日消费
   Map<String,String> queryConsumAndArrease();

    //查询不同状态的公司数
    Map<String,String> queryAccountState();

    //查询每天的点击量和消费情况
    List<Map<String,String>> queryConsum(AccountBean accountBean);

    //查询点击量统计信息
    List<AccountBean> queryFirmSummary(AccountBean accountBean);

    //前台首页 昨日消费 今日消费 账户余额，账户预算
    Map<String,String> queryUnitAccout(Integer accId);

    //前台首页 查询创意待审核、被拒的个数
    Map<String,String> queryCheckIdea(Integer accId);

    //前台首页 账户每日点击量统计
    List<AccountBean> queryAccoutClickNum(Page<AccountBean> result, @Param("account") AccountBean accountBean);


}
