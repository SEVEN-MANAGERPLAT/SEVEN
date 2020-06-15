package com.seven.aemp.dao;


import org.apache.ibatis.annotations.*;

import java.util.Date;

/**
 * @desc:
 * @date: 2020-01-02 14:11
 * @author: dx
 * @version: 1.0
 */
public interface CommonDao {

    //获取数据库时间
    @Select("SELECT NOW()")
    public Date queryDBTime();

}
