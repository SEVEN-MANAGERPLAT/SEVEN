package com.seven.aemp.dao;


import com.seven.aemp.bean.UmsResourceBean;
import com.seven.aemp.bean.UmsResourceCategoryBean;

import java.util.List;

public interface UmsResourceCategoryDao {

    List<UmsResourceCategoryBean> queryUmsResourceCategoryList();

//    long countByExample(UmsResourceCategoryExample example);
//
//    int deleteByExample(UmsResourceCategoryExample example);
//
//    int deleteByPrimaryKey(Long id);
//
//    int insert(UmsResourceCategory record);
//
//    int insertSelective(UmsResourceCategory record);
//
//    List<UmsResourceCategory> selectByExample(UmsResourceCategoryExample example);
//
//    UmsResourceCategory selectByPrimaryKey(Long id);
//
//    int updateByExampleSelective(@Param("record") UmsResourceCategory record, @Param("example") UmsResourceCategoryExample example);
//
//    int updateByExample(@Param("record") UmsResourceCategory record, @Param("example") UmsResourceCategoryExample example);
//
//    int updateByPrimaryKeySelective(UmsResourceCategory record);
//
//    int updateByPrimaryKey(UmsResourceCategory record);
}