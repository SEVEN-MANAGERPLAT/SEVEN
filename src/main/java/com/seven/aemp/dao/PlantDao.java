package com.seven.aemp.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seven.aemp.bean.PlantBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author mwl
 * @since 2019-11-19
 */
public interface PlantDao extends BaseMapper<PlantBean> {

    List<PlantBean> queryPlant(@Param("plan") PlantBean plantBean);

    //分页创意查询
    List<PlantBean> queryPlant(Page<PlantBean> result, @Param("plan") PlantBean plantBean);

    //后台查询计划报表
    IPage queryPlantBackReport(@Param("page") IPage page, @Param("plantBean") PlantBean plantBean);
}
