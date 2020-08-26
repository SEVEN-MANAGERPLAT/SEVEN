package com.seven.aemp.domain;

import com.seven.aemp.bean.PlantBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PlantResultBean extends PlantBean {

    //展现量
    private String exhibits;

    //点击量
    private String clickNum;

    //点击率
    private String clickRate;

    //单价
    private String unitPrice;

    //消费
    private String consume;

}
