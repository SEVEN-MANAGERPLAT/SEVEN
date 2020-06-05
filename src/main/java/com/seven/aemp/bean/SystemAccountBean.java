package com.seven.aemp.bean;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2020-03-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("system_account")
public class SystemAccountBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer sysId;

    private String sysAccount;

    private String sysPwd;

    private String firmName;

    private String firmAddress;

    private String industry;

    private String certificate;

    private String linkMan;

    private String linkPhone;

    private String linkEmail;

    /**
     * 1、销售专员
            2、运营专员
     */
    private Integer empType;

    private LocalDateTime createDate;

    private Integer isUse;


}
