package com.seven.aemp.service;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * @desc:
 * @date: 2020-06-10 13:01
 * @author: dx
 * @version: 1.0
 */
public interface DynamicSecurityService {

    /**
     * 加载资源ANT通配符和资源对应MAP
     */
    Map<String, ConfigAttribute> loadDataSource();
}
