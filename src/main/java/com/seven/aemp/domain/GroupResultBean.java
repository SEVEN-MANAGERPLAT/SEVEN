package com.seven.aemp.domain;

import com.seven.aemp.bean.GroupBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GroupResultBean extends GroupBean {

    //展现量
    private int exhibits;

    //点击量
    private BigDecimal clickNum;

    //点击率
    private BigDecimal clickRate;

    //单价
    private BigDecimal unitPrice;

    //消费
    private BigDecimal consume;

    //余额
    private BigDecimal balance;
}
