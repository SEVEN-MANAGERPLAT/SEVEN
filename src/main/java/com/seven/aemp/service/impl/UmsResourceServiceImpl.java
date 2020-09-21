package com.seven.aemp.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seven.aemp.bean.AccountBean;
import com.seven.aemp.bean.UmsMenuBean;
import com.seven.aemp.bean.UmsResourceBean;
import com.seven.aemp.dao.UmsResourceDao;
import com.seven.aemp.model.UmsResourceExample;
import com.seven.aemp.service.UmsResourceService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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


    @Override
    public int create(UmsResourceBean umsResource) {
        umsResource.setCreateTime(new Date());
        return umsResourceDao.insert(umsResource);
    }

    @Override
    public int updateResource(UmsResourceBean umsResourceBean) {
        return umsResourceDao.updateResource(umsResourceBean);
    }

    @Override
    public Page<UmsResourceBean> umsResourceList(String page, String pageSize, UmsResourceBean umsResourceBean) throws Exception {
        if (StringUtils.isBlank(page)) {
            page = "1";
        }
        if (StringUtils.isBlank(pageSize)) {
            pageSize = "10";
        }
        Page<UmsResourceBean> result = new Page<>(Long.valueOf(page), Long.valueOf(pageSize));
        return result.setRecords(umsResourceDao.queryUmsResource(result, umsResourceBean));
    }

    @Override
    public List<UmsResourceBean> listAll() {
        return umsResourceDao.selectByExample(new UmsResourceExample());
    }
}
