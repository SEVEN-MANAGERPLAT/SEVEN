package com.seven.aemp.config;

import com.seven.aemp.bean.UmsResourceBean;
import com.seven.aemp.service.AccountService;
import com.seven.aemp.service.DynamicSecurityService;
import com.seven.aemp.service.UmsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @desc:Security配置
 * @date: 2020-06-10 13:03
 * @author: dx
 * @version: 1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SysSecurityConfig extends SecurityConfig {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UmsResourceService umsResourceService;

    //SpringSecurity定义的核心接口，用于根据用户名获取用户信息，需要自行实现；
    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> {
            //SpringSecurity定义用于封装用户信息的类（主要是用户信息和权限），需要自行实现；
            return accountService.loadUserByUsername(username);
        };
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                //查询所有资源，待修改
                List<UmsResourceBean> resourceList = umsResourceService.queryUmsResource(new UmsResourceBean());
                for (UmsResourceBean resource : resourceList) {
                    map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getName()));
                }
                return map;
            }
        };
    }
}
