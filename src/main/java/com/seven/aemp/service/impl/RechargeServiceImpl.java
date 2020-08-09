package com.seven.aemp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seven.aemp.bean.RechargeBean;
import com.seven.aemp.dao.RechargeDao;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.service.RechargeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seven.aemp.util.TimeUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 充值表 服务实现类
 * </p>
 *
 * @author mwl
 * @since 2020-08-07
 */
@Service
public class RechargeServiceImpl extends ServiceImpl<RechargeDao, RechargeBean> implements RechargeService {

    @Autowired
    private RechargeDao rechargeDao;

    @Override
    public List<RechargeBean> queryRechargeList(RechargeBean rechargeBean) throws Exception {
        return rechargeDao.queryRechargeList(rechargeBean);
    }

    @Override
    public int addRechargeInfo(RechargeBean rechargeBean) throws Exception {
        if(StringUtils.isEmpty(rechargeBean.getAccId())) throw new MessageException("充值账号不能为空");
        if(StringUtils.isEmpty(rechargeBean.getReMoney())) throw new MessageException("充值金额不能为空");

        String nowDate = TimeUtil.getDateYYYY_MM_DD_HH_MM(TimeUtil.getDBTime());

        return rechargeDao.addRechargeInfo(rechargeBean.setCreateDate(nowDate));
    }
}
