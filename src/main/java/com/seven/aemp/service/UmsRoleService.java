package com.seven.aemp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.seven.aemp.bean.UmsMenuBean;
import com.seven.aemp.bean.UmsResourceBean;
import com.seven.aemp.bean.UmsRoleBean;
import org.springframework.transaction.annotation.Transactional;

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


    /**
     * 添加角色
     */
    int create(UmsRoleBean role);


    int updateRole(UmsRoleBean roleBean);

    /**
     * 修改角色信息
     */
//    int update(Long id, UmsRoleBean role);

//    /**
//     * 批量删除角色
//     */
//    int delete(List<Long> ids);
//
//    /**
//     * 获取指定角色权限
//     */
////    List<UmsPermission> getPermissionList(Long roleId);
//
//    /**
//     * 修改指定角色的权限
//     */
//    @Transactional
//    int updatePermission(Long roleId, List<Long> permissionIds);

    /**
     * 获取所有角色列表
     */
    List<UmsRoleBean> list();

    /**
     * 分页获取角色列表
     */
//    List<UmsRoleBean> list(String keyword, Integer pageSize, Integer pageNum);

    //查询角色列表
    public Page<UmsRoleBean> umsRoleList(String page, String pageSize, UmsRoleBean ideaBean) throws Exception;

    /**
     * 获取角色相关菜单
     */
    List<UmsMenuBean> listMenu(Long roleId);

//    /**
//     * 获取角色相关资源
//     */
////    List<UmsResource> listResource(Long roleId);
//
    /**
     * 给角色分配菜单
     */
    @Transactional
    int allocMenu(Long roleId, List<Long> menuIds);

    /**
     * 给角色分配资源
     */
    @Transactional
    int allocResource(Long roleId, List<Long> resourceIds);
}
