package com.seven.aemp.security;

import com.seven.aemp.bean.AccountBean;
import com.seven.aemp.bean.UmsResourceBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @desc:
 * @date: 2020-04-09 15:22
 * @author: dx
 * @version: 1.0
 */
public class AdminUserDetails implements UserDetails {

    private AccountBean umsAdmin;

    private List<UmsResourceBean> resourceBeanList;

    public AdminUserDetails(AccountBean umsAdmin, List<UmsResourceBean> resourceBeanList) {
        this.umsAdmin = umsAdmin;
        this.resourceBeanList = resourceBeanList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return resourceBeanList
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getId() + ":" + role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdmin.getAccountPwd();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getAccountName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return umsAdmin.getAccountState().equals(1);
    }
}
