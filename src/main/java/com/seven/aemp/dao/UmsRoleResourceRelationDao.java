package com.seven.aemp.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seven.aemp.model.UmsRoleResourceRelation;
import com.seven.aemp.model.UmsRoleResourceRelationExample;



public interface UmsRoleResourceRelationDao   extends BaseMapper<UmsRoleResourceRelation> {


    int deleteByExample(UmsRoleResourceRelationExample example);



    int insert(UmsRoleResourceRelation record);


}