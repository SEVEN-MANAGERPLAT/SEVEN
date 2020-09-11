package com.seven.aemp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seven.aemp.model.UmsRoleMenuRelation;
import com.seven.aemp.model.UmsRoleMenuRelationExample;


public interface UmsRoleMenuRelationDao  extends BaseMapper<UmsRoleMenuRelation> {


    int deleteByExample(UmsRoleMenuRelationExample example);


    int insert(UmsRoleMenuRelation record);


}