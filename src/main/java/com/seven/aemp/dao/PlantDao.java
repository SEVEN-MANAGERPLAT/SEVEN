package com.seven.aemp.dao;

import com.seven.aemp.bean.PlantBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mwl
 * @since 2019-11-19
 */
@Mapper
public interface PlantDao extends BaseMapper<PlantBean> {

    List<PlantBean> queryPlant(PlantBean plantBean);
}
