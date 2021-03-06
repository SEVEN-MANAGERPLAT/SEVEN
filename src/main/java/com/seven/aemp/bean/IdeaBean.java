package com.seven.aemp.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.io.Serializable;
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
@TableName("extent_idea")
public class IdeaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "IDEA_ID", type = IdType.AUTO)
    private String ideaId;

    private String ideaName;

    private String planId;

    @TableField(exist = false)
    private String planName;

    private String egId;

    @TableField(exist = false)
    private String egName;

    private Integer advertiseTypeId;

    private String updateUrl;

    private String ideaDescribe;

    private String ideaDate;

    //展现量
    @TableField(exist = false)
    private String exhibits;

    //点击量
    @TableField(exist = false)
    private String clickNum;

    //点击率
    @TableField(exist = false)
    private String clickRate;

    //单价
    @TableField(exist = false)
    private String unitPrice;

    //消费
    @TableField(exist = false)
    private String consume;

    private String state;

    private String prodUrl;

    private String checkState;

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
    @TableField(exist = false)
    private String accId;

    @TableField(exist = false)
    private String page;

    @TableField(exist = false)
    private String pageSize;

    //余额
    @TableField(exist = false)
    private BigDecimal balance;
}
