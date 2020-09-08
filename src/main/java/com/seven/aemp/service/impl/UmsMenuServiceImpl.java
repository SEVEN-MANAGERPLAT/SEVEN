package com.seven.aemp.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seven.aemp.bean.UmsMenuBean;
import com.seven.aemp.dao.UmsMenuDao;
import com.seven.aemp.service.UmsMenuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 后台菜单管理Service实现类
 * Created by macro on 2020/2/2.
 */
@Service
public class UmsMenuServiceImpl implements UmsMenuService {
    @Override
    public int updateHidden(Long id, Integer hidden) {
        return 0;
    }

    @Autowired
    private UmsMenuDao umsMenuDao;

    @Override
    public int create(UmsMenuBean umsMenu) {
        umsMenu.setCreateTime(new Date());
        updateLevel(umsMenu);
        return umsMenuDao.insert(umsMenu);
    }

    /**
     * 修改菜单层级
     */
    private void updateLevel(UmsMenuBean umsMenu) {
        if (umsMenu.getParentId() == 0) {
            //没有父菜单时为一级菜单
            umsMenu.setLevel(0);
        } else {
            //有父菜单时选择根据父菜单level设置
//            UmsMenuBean parentMenu = menuMapper.selectByPrimaryKey(umsMenu.getParentId());
            UmsMenuBean parentMenu = new UmsMenuBean();
            if (parentMenu != null) {
                umsMenu.setLevel(parentMenu.getLevel() + 1);
            } else {
                umsMenu.setLevel(0);
            }
        }
    }

    public Page<UmsMenuBean> umsMenuList(Integer page, Integer pageSize, UmsMenuBean umsMenuBean) throws Exception {
        Page<UmsMenuBean> result = new Page<>(Long.valueOf(page), Long.valueOf(pageSize));
        return result.setRecords(umsMenuDao.umsMenuList(result, umsMenuBean));
    }

    @Override
    public int updateMenu(UmsMenuBean umsMenu) {
        return umsMenuDao.updateMenu(umsMenu);
    }

    @Override
    public UmsMenuBean queryMenu(UmsMenuBean umsMenuBean) throws Exception {
        return umsMenuDao.umsMenuList(umsMenuBean);
    }
//
//    @Override
//    public UmsMenu getItem(Long id) {
//        return menuMapper.selectByPrimaryKey(id);
//    }
//
//    @Override
//    public int delete(Long id) {
//        return menuMapper.deleteByPrimaryKey(id);
//    }
//
//    @Override
//    public List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum) {
//        PageHelper.startPage(pageNum, pageSize);
//        UmsMenuExample example = new UmsMenuExample();
//        example.setOrderByClause("sort desc");
//        example.createCriteria().andParentIdEqualTo(parentId);
//        return menuMapper.selectByExample(example);
//    }
//
//    @Override
//    public List<UmsMenuNode> treeList() {
//        List<UmsMenu> menuList = menuMapper.selectByExample(new UmsMenuExample());
//        List<UmsMenuNode> result = menuList.stream()
//                .filter(menu -> menu.getParentId().equals(0L))
//                .map(menu -> covertMenuNode(menu, menuList)).collect(Collectors.toList());
//        return result;
//    }
//
//    @Override
//    public int updateHidden(Long id, Integer hidden) {
//        UmsMenu umsMenu = new UmsMenu();
//        umsMenu.setId(id);
//        umsMenu.setHidden(hidden);
//        return menuMapper.updateByPrimaryKeySelective(umsMenu);
//    }
//
//    /**
//     * 将UmsMenu转化为UmsMenuNode并设置children属性
//     */
//    private UmsMenuNode covertMenuNode(UmsMenu menu, List<UmsMenu> menuList) {
//        UmsMenuNode node = new UmsMenuNode();
//        BeanUtils.copyProperties(menu, node);
//        List<UmsMenuNode> children = menuList.stream()
//                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
//                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
//        node.setChildren(children);
//        return node;
//    }
}
