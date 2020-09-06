package com.seven.aemp.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seven.aemp.bean.PlantBean;
import com.seven.aemp.bean.UmsMenuBean;
import com.seven.aemp.bean.UmsResourceBean;
import com.seven.aemp.bean.UmsRoleBean;
import com.seven.aemp.dao.UmsRoleDao;
import com.seven.aemp.service.UmsRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public int create(UmsRoleBean role) {
        role.setCreateTime(new Date());
        role.setAdminCount(0);
        role.setSort(0);
        return umsRoleDao.insert(role);
    }

//    @Override
//    public int update(Long id, UmsRoleBean role) {
//        role.setId(id);
//        return umsRoleDao.updateByPrimaryKeySelective(role);
//    }

//    @Override
//    public List<UmsRoleBean> list(String keyword, Integer pageSize, Integer pageNum) {
//
//        Page<PlantBean> result = new Page<>(pageNum, pageSize);
//        return result.setRecords(umsRoleDao.queryRole(result, new UmsRoleBean().setName(keyword)));
//    }

    public Page<UmsRoleBean> umsRoleList(String page, String pageSize, UmsRoleBean umsRoleBean) throws Exception {
        if (StringUtils.isBlank(page)) {
            page = "1";
        }
        if (StringUtils.isBlank(pageSize)) {
            pageSize = "10";
        }
        Page<UmsRoleBean> result = new Page<>(Long.valueOf(page), Long.valueOf(pageSize));
        return result.setRecords(umsRoleDao.umsRoleList(result, umsRoleBean));
    }

}
