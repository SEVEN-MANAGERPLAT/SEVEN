package com.seven.aemp.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seven.aemp.bean.UmsMenuBean;
import com.seven.aemp.bean.UmsResourceBean;
import com.seven.aemp.bean.UmsRoleBean;
import com.seven.aemp.dao.UmsRoleDao;
import com.seven.aemp.dao.UmsRoleMenuRelationDao;
import com.seven.aemp.dao.UmsRolePermissionRelationDao;
import com.seven.aemp.dao.UmsRoleResourceRelationDao;
import com.seven.aemp.model.UmsRoleMenuRelation;
import com.seven.aemp.model.UmsRoleMenuRelationExample;
import com.seven.aemp.model.UmsRoleResourceRelation;
import com.seven.aemp.model.UmsRoleResourceRelationExample;
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

    @Autowired
    private UmsRolePermissionRelationDao rolePermissionRelationDao;

    @Autowired
    private UmsRoleMenuRelationDao roleMenuRelationDao;

    @Autowired
    private UmsRoleResourceRelationDao roleResourceRelationDao;

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

    @Override
    public int updateRole(UmsRoleBean umsRoleBean) {
        return umsRoleDao.updateById(umsRoleBean);
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

    @Override
    public List<UmsRoleBean> list() {
        return umsRoleDao.umsRoleList();
    }

    @Override
    public List<UmsMenuBean> listMenu(Long roleId) {
        return umsRoleDao.getMenuListByRoleId(roleId);
    }

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

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        //先删除原有关系
        UmsRoleMenuRelationExample example=new UmsRoleMenuRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleMenuRelationDao.deleteByExample(example);
        //批量插入新关系
        for (Long menuId : menuIds) {
            UmsRoleMenuRelation relation = new UmsRoleMenuRelation();
            relation.setRoleId(roleId);
            relation.setMenuId(menuId);
            roleMenuRelationDao.insert(relation);
        }
        return menuIds.size();
    }


    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        //先删除原有关系
        UmsRoleResourceRelationExample example=new UmsRoleResourceRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleResourceRelationDao.deleteByExample(example);
        //批量插入新关系
        for (Long resourceId : resourceIds) {
            UmsRoleResourceRelation relation = new UmsRoleResourceRelation();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            roleResourceRelationDao.insert(relation);
        }
//        adminCacheService.delResourceListByRole(roleId);
        return resourceIds.size();
    }
}
