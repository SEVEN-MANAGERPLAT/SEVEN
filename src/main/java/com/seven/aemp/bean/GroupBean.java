package com.seven.aemp.bean;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
@TableName("extent_group")
public class GroupBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "eg_id", type = IdType.AUTO)
    private String egId;

    private String planId;

    @TableField(exist = false)
    private String planName;

    private String egName;

    private String planDate;

    private String predict;

    private String comparePattern;

    private String bill;

    private String throwUrl;

    private Integer sourceId;

    private String sex;

    /**
     * 0：<18
            1：18-23
            2：23-30
            3：31-40
            4：41-50
            5：>50
     */
    private String age;

    /**
     * 0：系统定向
            1：自定义
     */
    private Integer intrest;

    /**
     * 0：IOS
            1：Androd
     */
    private Integer plat;

    /**
     * 0：应用
            1：游戏
     */
    private Integer appAction;

    /**
     * 0：按省市
      1：按县区
      2：按商圈
     */
    private Integer throwArea;


    private String throwBegDate;

    private String throwEndDate;

    private String throwSegDate;

    /**
     * 0：取消
       1：使用中
     */
    private Integer state;

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

    //账号ID
    @TableField(exist = false)
    private String clickNum;
}
