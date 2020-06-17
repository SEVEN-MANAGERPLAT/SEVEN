package com.seven.aemp.dao;

import com.seven.aemp.bean.GroupBean;
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
public interface GroupDao extends BaseMapper<GroupBean> {

    //查询组内创意，一段时间内汇总点击量
    List<GroupBean> queryGroup(GroupBean groupBean);

    //查询组内创意，一段时间内单日点击量数据
    List<GroupBean> queryGroupIdeaClickByUnitDay(GroupBean groupBean);
}
