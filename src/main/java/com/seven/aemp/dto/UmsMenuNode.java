package com.seven.aemp.dto;

import com.seven.aemp.bean.UmsMenuBean;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 后台菜单节点封装
 * Created by macro on 2020/2/4.
 */
@Getter
@Setter
public class UmsMenuNode extends UmsMenuBean {
    private List<UmsMenuNode> children;
}
