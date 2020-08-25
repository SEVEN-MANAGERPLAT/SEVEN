package com.seven.aemp.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

    @TableField(exist = false)
    private String exhibits;

    @TableField(exist = false)
    private String clickNum;

    @TableField(exist = false)
    private String clickRate;

    @TableField(exist = false)
    private String unitPrice;

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
}
