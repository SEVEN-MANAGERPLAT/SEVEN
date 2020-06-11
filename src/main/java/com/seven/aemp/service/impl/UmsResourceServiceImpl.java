package com.seven.aemp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seven.aemp.bean.AccountBean;
import com.seven.aemp.bean.UmsResourceBean;
import com.seven.aemp.dao.UmsResourceDao;
import com.seven.aemp.service.UmsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc:资源Service实现类
 * @date: 2020-06-11 11:38
 * @author: dx
 * @version: 1.0
 */
@Service
public class UmsResourceServiceImpl extends ServiceImpl<UmsResourceDao, UmsResourceBean> implements UmsResourceService {

    @Autowired
    private UmsResourceDao umsResourceDao;

    @Override
    public List<UmsResourceBean> queryUmsResource(UmsResourceBean umsResourceBean) {
        return umsResourceDao.queryUmsResource(umsResourceBean);
    }

    @Override
    public List<UmsResourceBean> queryUmsResourceByAdminId(AccountBean accountBean) {
        return umsResourceDao.queryUmsResourceByAdminId(accountBean);
    }
}
