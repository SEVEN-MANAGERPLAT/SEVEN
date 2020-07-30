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

    private Integer businessId;

    //运营人员
    private Integer operateId;

    //销售人员
    private Integer saleId;

    //审核状态
    private Integer checkState;

    private String accountState;

    @TableField(exist = false)
    private String page;

    @TableField(exist = false)
    private String pageSize;
}
