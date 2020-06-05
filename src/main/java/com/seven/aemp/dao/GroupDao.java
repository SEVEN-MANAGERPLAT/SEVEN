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

    List<GroupBean> queryGroup(GroupBean groupBean);
}
