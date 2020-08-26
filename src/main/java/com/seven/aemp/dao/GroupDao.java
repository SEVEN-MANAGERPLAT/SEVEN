package com.seven.aemp.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seven.aemp.bean.GroupBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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
public interface GroupDao extends BaseMapper<GroupBean> {

    //查询组内创意，一段时间内汇总点击量
    List<GroupBean> queryGroup(@Param("group") GroupBean groupBean);

    //分页组查询
    List<GroupBean> queryGroup(Page<GroupBean> result, @Param("group") GroupBean groupBean);

    //查询组内，一段时间内单日点击量数据
    List<GroupBean> queryGroupIdeaClickByUnitDay(Page<GroupBean> result, @Param("group") GroupBean groupBean);

    int insertGroup(GroupBean groupBean);

}
