package com.seven.aemp.dao;

import com.seven.aemp.bean.RechargeBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 充值表 Mapper 接口
 * </p>
 *
 * @author mwl
 * @since 2020-08-07
 */
public interface RechargeDao extends BaseMapper<RechargeBean> {

    //查询充值信息
    List<RechargeBean> queryRechargeList(RechargeBean rechargeBean);

    //查询充值信息
    int addRechargeInfo(RechargeBean rechargeBean);
}
