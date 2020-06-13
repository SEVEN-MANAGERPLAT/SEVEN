package com.seven.aemp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seven.aemp.bean.AccountBean;
import com.seven.aemp.bean.UmsResourceBean;

import java.util.List;

/**
 * @desc:
 * @date: 2020-06-11 11:39
 * @author: dx
 * @version: 1.0
 */
public interface UmsResourceDao extends BaseMapper<UmsResourceBean> {

    //查询
    List<UmsResourceBean> queryUmsResource(UmsResourceBean umsResourceBean);

    List<UmsResourceBean> queryUmsResourceByAdminId(AccountBean accountBean);


}
