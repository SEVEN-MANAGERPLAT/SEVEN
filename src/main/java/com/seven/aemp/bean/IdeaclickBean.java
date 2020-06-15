package com.seven.aemp.bean;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-04-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ideaclick")
public class IdeaclickBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "IC_ID", type = IdType.AUTO)
    private Integer icId;

    private String ideaId;

    private String ideaDate;

    private String isExhibit;

    private String clickNum;
}
