package com.seven.aemp.bean;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 充值表
 * </p>
 *
 * @author mwl
 * @since 2020-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("recharge")
@ApiModel(value="RechargeBean对象", description="充值表")
public class RechargeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "充值ID")
    @TableId(value = "RE_ID", type = IdType.AUTO)
    private String reId;

    @ApiModelProperty(value = "账户ID")
    private String accId;

    @ApiModelProperty(value = "充值金额")
    private String reMoney;

    @ApiModelProperty(value = "充值时间")
    private String createDate;


}
