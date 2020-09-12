package com.seven.aemp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seven.aemp.bean.UmsRoleBean;
import com.seven.aemp.model.UmsAdminRoleRelation;
import com.seven.aemp.model.UmsAdminRoleRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dx
 * @since 2020-08-29
 */
public interface UmsAdminRoleRelationDao extends BaseMapper<UmsAdminRoleRelation> {

    /**
     * 批量插入用户角色关系
     */
    int insertList(@Param("list") List<UmsAdminRoleRelation> adminRoleRelationList);

    /**
     * 获取用于所有角色
     */
//    List<UmsRoleBean> getRoleList(@Param("adminId") Long adminId);

//    /**
//     * 获取用户所有角色权限
//     */
//    List<UmsPermissionBean> getRolePermissionList(@Param("adminId") Long adminId);
//
//    /**
//     * 获取用户所有权限(包括+-权限)
//     */
//    List<UmsPermissionBean> getPermissionList(@Param("adminId") Long adminId);
//
//    /**
//     * 获取用户所有可访问资源
//     */
//    List<UmsResourceBean> getResourceList(@Param("adminId") Long adminId);
//
//    /**
//     * 获取资源相关用户ID列表
//     */
//    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);


    int deleteByExample(UmsAdminRoleRelationExample example);
}
