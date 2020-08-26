package com.seven.aemp.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author mwl
 * @since 2019-11-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("plant")
public class PlantBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "PLAN_ID", type = IdType.AUTO)
    private String planId;

    //计划预算
    private String planPredict;

    /**
     * 0：已暂停
       1：已开启
       2：已删除
     */
    private String state;

    //计划名称
    private String planName;

    private String createDate;

    /**
     1：今天
     2：昨天
     3：近七天
     4：近30天
     5：时间段内的数据
     */
    @TableField(exist = false)
    private String dateType;

    // 开始时间
    @TableField(exist = false)
    private String begDate;

    //结束时间
    @TableField(exist = false)
    private String endDate;

    //账号ID
    private String accId;


    @TableField(exist = false)
    private String page;

    @TableField(exist = false)
    private String pageSize;
}
