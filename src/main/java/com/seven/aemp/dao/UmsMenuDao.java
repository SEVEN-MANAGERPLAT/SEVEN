package com.seven.aemp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seven.aemp.bean.UmsMenuBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsMenuDao  extends BaseMapper<UmsMenuBean> {
//    long countByExample(UmsMenuExample example);
//
//    int deleteByExample(UmsMenuExample example);
//
//    int deleteByPrimaryKey(Long id);

    int insert(UmsMenuBean record);


    /**
     * 分页查询目录
     * @param result
     */
    List<UmsMenuBean> umsMenuList(Page<UmsMenuBean> result, @Param("menu") UmsMenuBean umsMenuBean);

    UmsMenuBean umsMenuList(@Param("menu") UmsMenuBean umsMenuBean);

    List<UmsMenuBean> umsMenu(@Param("menu") UmsMenuBean umsMenuBean);

//    int insertSelective(UmsMenu record);
//
//    List<UmsMenu> selectByExample(UmsMenuExample example);
//
//    UmsMenu selectByPrimaryKey(Long id);
//
//    int updateByExampleSelective(@Param("record") UmsMenu record, @Param("example") UmsMenuExample example);
//
//    int updateByExample(@Param("record") UmsMenu record, @Param("example") UmsMenuExample example);
//
    int updateMenu(UmsMenuBean record);
//
//    int updateByPrimaryKey(UmsMenu record);
}