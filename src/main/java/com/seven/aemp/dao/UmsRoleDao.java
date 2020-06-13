package com.seven.aemp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seven.aemp.bean.UmsMenuBean;
import com.seven.aemp.bean.UmsResourceBean;
import com.seven.aemp.bean.UmsRoleBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义后台角色管理Dao
 * Created by macro on 2020/2/2.
 */
public interface UmsRoleDao extends BaseMapper<UmsRoleBean> {
    /**
     * 根据后台用户ID获取菜单
     */
    List<UmsMenuBean> getMenuList(@Param("adminId") Long adminId);
    /**
     * 根据角色ID获取菜单
     */
    List<UmsMenuBean> getMenuListByRoleId(@Param("roleId") Long roleId);
    /**
     * 根据角色ID获取资源
     */
    List<UmsResourceBean> getResourceListByRoleId(@Param("roleId") Long roleId);
}
