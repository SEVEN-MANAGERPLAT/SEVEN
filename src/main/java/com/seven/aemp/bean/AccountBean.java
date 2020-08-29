package com.seven.aemp.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("account")
public class AccountBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "account_id", type = IdType.AUTO)
    private Integer accountId;

    private String accountName;

    private String accountPwd;

    private String firmName;

    private String address;

    private String industry;

    private String certificate;

    private String linkMan;

    private String phone;

    private String email;

    private String isUse;

    private Integer businessId;

    //运营人员
    private Integer operateId;

    //销售人员
    private Integer saleId;

    //审核状态
    private Integer checkState;

    //操作状态
    private Integer operateState;

    private String accountState;

    @TableField(exist = false)
    private String ideaDate;

    @TableField(exist = false)
    private String clickRate;

    @TableField(exist = false)
    private String clickNum;

    private String dayPredect;


    @TableField(exist = false)
    private String page;

    @TableField(exist = false)
    private String pageSize;

    @TableField(exist = false)
    private String exhibits;

    @TableField(exist = false)
    private String thousandConsume;

    @TableField(exist = false)
    private String CONSUME;

    @TableField(exist = false)
    private String unitPrice;

    @TableField(exist = false)
    private String balance;

    @TableField(exist = false)
    private String totle;

    @TableField(exist = false)
    private String throwing;

    @TableField(exist = false)
    private String stoped;

    @TableField(exist = false)
    private String checked;

    @TableField(exist = false)
    private String refuse;

    @TableField(exist = false)
    private String begDate;

    @TableField(exist = false)
    private String endDate;

}
