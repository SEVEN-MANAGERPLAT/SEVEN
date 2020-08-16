package com.seven.aemp.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seven.aemp.bean.AccountBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

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
@Mapper
public interface AccountDao extends BaseMapper<AccountBean> {
    //查询用户
    public List<AccountBean> queryAccount( @Param("account") AccountBean accountBean);

    //分页组查询
    List<AccountBean> queryAccount(Page<AccountBean> result, @Param("account") AccountBean accountBean);

    //修改用户信息
    int updateAccount(AccountBean accountBean);

    //账户剩余金额和昨日消费
   Map<String,String> queryConsumAndArrease();
}
