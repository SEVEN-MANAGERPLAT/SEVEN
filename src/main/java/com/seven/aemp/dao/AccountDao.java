package com.seven.aemp.dao;

import com.seven.aemp.bean.AccountBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

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
    public List<AccountBean> queryAccount(AccountBean accountBean);

    //修改用户信息
    public int updateAccount(AccountBean accountBean);
}
