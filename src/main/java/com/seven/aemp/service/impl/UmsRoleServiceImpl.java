package com.seven.aemp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seven.aemp.bean.UmsMenuBean;
import com.seven.aemp.bean.UmsResourceBean;
import com.seven.aemp.bean.UmsRoleBean;
import com.seven.aemp.dao.UmsRoleDao;
import com.seven.aemp.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc:
 * @date: 2020-06-12 11:12
 * @author: dx
 * @version: 1.0
 */
@Service
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleDao, UmsRoleBean> implements UmsRoleService {

    @Autowired
    private UmsRoleDao umsRoleDao;

    @Override
    public List<UmsMenuBean> getMenuList(Long adminId) {
        return umsRoleDao.getMenuList(adminId);
    }

    @Override
    public List<UmsMenuBean> getMenuListByRoleId(Long roleId) {
        return umsRoleDao.getMenuListByRoleId(roleId);
    }

    @Override
    public List<UmsResourceBean> getResourceListByRoleId(Long roleId) {
        return umsRoleDao.getResourceListByRoleId(roleId);
    }
}
