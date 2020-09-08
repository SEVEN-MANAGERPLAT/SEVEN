package com.seven.aemp.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seven.aemp.bean.UmsMenuBean;

/**
 * 后台菜单管理Service
 * Created by macro on 2020/2/2.
 */
public interface UmsMenuService {
    /**
     * 创建后台菜单
     */
    int create(UmsMenuBean umsMenu);

    //查询目录列表
    public Page<UmsMenuBean> umsMenuList(Integer page, Integer pageSize, UmsMenuBean umsMenuBean) throws Exception;

    /**
     * 修改后台菜单
     */
    int updateMenu(UmsMenuBean umsMenu);

    public UmsMenuBean queryMenu(UmsMenuBean umsMenuBean) throws Exception;


//    /**
//     * 根据ID获取菜单详情
//     */
//    UmsMenu getItem(Long id);
//
//    /**
//     * 根据ID删除菜单
//     */
//    int delete(Long id);
//
//    /**
//     * 分页查询后台菜单
//     */
//    List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum);
//
//    /**
//     * 树形结构返回所有菜单列表
//     */
//    List<UmsMenuNode> treeList();

    /**
     * 修改菜单显示状态
     */
    int updateHidden(Long id, Integer hidden);
}
