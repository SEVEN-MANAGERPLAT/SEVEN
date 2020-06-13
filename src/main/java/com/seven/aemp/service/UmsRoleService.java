package com.seven.aemp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seven.aemp.bean.UmsMenuBean;
import com.seven.aemp.bean.UmsResourceBean;
import com.seven.aemp.bean.UmsRoleBean;

import java.util.List;

/**
 * @desc:
 * @date: 2020-06-12 11:11
 * @author: dx
 * @version: 1.0
 */
public interface UmsRoleService extends IService<UmsRoleBean> {

    List<UmsMenuBean> getMenuList(Long adminId);
    /**
     * 根据角色ID获取菜单
     */
    List<UmsMenuBean> getMenuListByRoleId(Long roleId);
    /**
     * 根据角色ID获取资源
     */
    List<UmsResourceBean> getResourceListByRoleId(Long roleId);
}
