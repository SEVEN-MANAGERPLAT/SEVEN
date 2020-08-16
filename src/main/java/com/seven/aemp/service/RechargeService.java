package com.seven.aemp.service;

import com.seven.aemp.bean.RechargeBean;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 充值表 服务类
 * </p>
 *
 * @author mwl
 * @since 2020-08-07
 */
public interface RechargeService extends IService<RechargeBean> {

    //查询充值信息
    public List<RechargeBean> queryRechargeList(RechargeBean rechargeBean) throws Exception;

    //查询充值信息
    public int addRechargeInfo(RechargeBean rechargeBean) throws Exception;


}
