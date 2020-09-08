package com.seven.aemp.service.impl;


import com.seven.aemp.bean.UmsMenuBean;
import com.seven.aemp.bean.UmsResourceBean;
import com.seven.aemp.bean.UmsResourceCategoryBean;
import com.seven.aemp.dao.UmsResourceCategoryDao;
import com.seven.aemp.service.UmsResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * 后台资源分类管理Service实现类
 * Created by macro on 2020/2/5.
 */
@Service
public class UmsResourceCategoryServiceImpl implements UmsResourceCategoryService {
    @Autowired
    private UmsResourceCategoryDao umsResourceCategoryDao;

    @Override
    public int create(UmsResourceCategoryBean resourceCategoryBean) {
        resourceCategoryBean.setCreateTime(new Date());
        return umsResourceCategoryDao.insert(resourceCategoryBean);
    }

    @Override
    public List<UmsResourceCategoryBean> listAll() {
        UmsResourceCategoryBean umsResourceCategoryBean = new UmsResourceCategoryBean();
        return umsResourceCategoryDao.queryUmsResourceCategoryList();
    }

    @Override
    public int updateResourceCategory(UmsResourceCategoryBean resourceCategoryBean) {
        return umsResourceCategoryDao.updateResourceCategory(resourceCategoryBean);
    }

//    @Override
//    public int create(UmsResourceCategory umsResourceCategory) {
//        umsResourceCategory.setCreateTime(new Date());
//        return resourceCategoryMapper.insert(umsResourceCategory);
//    }
//
//    @Override
//    public int update(Long id, UmsResourceCategory umsResourceCategory) {
//        umsResourceCategory.setId(id);
//        return resourceCategoryMapper.updateByPrimaryKeySelective(umsResourceCategory);
//    }
//
//    @Override
//    public int delete(Long id) {
//        return resourceCategoryMapper.deleteByPrimaryKey(id);
//    }
}
