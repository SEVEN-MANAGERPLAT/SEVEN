package com.seven.aemp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seven.aemp.bean.AccountBean;
import com.seven.aemp.bean.UmsResourceBean;
import com.seven.aemp.common.Constant;
import com.seven.aemp.dao.AccountDao;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.security.AdminUserDetails;
import com.seven.aemp.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seven.aemp.service.UmsResourceService;
import com.seven.aemp.util.CookieTools;
import com.seven.aemp.util.JwtTokenUtil;
import org.apache.commons.lang.StringUtils;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author mwl
 * @since 2019-11-19
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountDao, AccountBean> implements AccountService {

    @Value("${tokenLife}")
    private int tokenLife;


    @Value("${accountLife}")
    private int accountLife;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UmsResourceService resourceService;

    @Override
    public List<AccountBean> queryAccount(AccountBean accountBean) {
        return accountDao.queryAccount(accountBean);
    }

    @Override
    public JSONObject login(AccountBean accountBean) throws Exception {
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isBlank(accountBean.getAccountName())) throw new MessageException("账号不能为空!");
        if (StringUtils.isBlank(accountBean.getAccountPwd())) throw new MessageException("密码不能为空!");
        List<AccountBean> accountBeans = queryAccount(accountBean);
        AccountBean bean = null;
        if (accountBeans.size() <= 0) {
            throw new MessageException("账号名或命名错误!");
        } else {
            bean = accountBeans.get(0);
            bean.setAccountPwd("");
            if ("0".equals(bean.getAccountState()) || "false".equals(bean.getAccountState()))
                throw new MessageException("该账号已被停用，请联系管理员!");
            HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            String accessToken = URLEncoder.encode(bean.getAccountName().concat("604800"), Constant.Charset.UTF8);
            jsonObject.put("accessToken", accessToken);
            jsonObject.put("accountData", bean);
            CookieTools.addCookie(response, "accessToken", accessToken, tokenLife);
            CookieTools.addCookie(response, "accountData", URLEncoder.encode(JSON.toJSONString(bean), Constant.Charset.UTF8), accountLife);
        }
        return jsonObject;
    }

    @Override
    public void updateAccount(AccountBean accountBean) throws Exception {
        if (StringUtils.isBlank(accountBean.getAccountName())) throw new MessageException("账号不能为空!");
        if (StringUtils.isBlank(accountBean.getAccountPwd())) throw new MessageException("密码不能为空!");
        if (accountDao.updateAccount(accountBean) <= 0) throw new MessageException("操作失败!");
    }

    @Override
    public AccountBean addAccount(AccountBean accountBean) throws Exception {
        if (StringUtils.isBlank(accountBean.getAccountName())) throw new MessageException("账号不能为空!");
        if (StringUtils.isBlank(accountBean.getAccountPwd())) throw new MessageException("密码不能为空!");
        List<AccountBean> accountBeans = queryAccount(new AccountBean().setAccountName(accountBean.getAccountName()));
        if (!accountBeans.isEmpty()) throw new MessageException("账号重复!");
        if (accountDao.insert(accountBean) <= 0) throw new MessageException("操作失败!");
        return accountBean;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) {
        List<AccountBean> accountBeans = queryAccount(new AccountBean().setAccountName(userName));
        if (accountBeans.isEmpty()) throw new UsernameNotFoundException("用户不存在!");
        //获取用户信息
        AccountBean accountBean = accountBeans.get(0);
        //需要查询用户权限
        List<UmsResourceBean> resourceList = resourceService.queryUmsResourceByAdminId(accountBean);
        return new AdminUserDetails(accountBean, resourceList);
    }

    @Override
    public JSONObject loginTwo(AccountBean accountBean) throws Exception {
        if (StringUtils.isBlank(accountBean.getAccountName())) throw new MessageException("账号不能为空!");
        if (StringUtils.isBlank(accountBean.getAccountPwd())) throw new MessageException("密码不能为空!");
        UserDetails userDetails = loadUserByUsername(accountBean.getAccountName());
        //String accountPwd = passwordEncoder.encode(accountBean.getAccountPwd());
        String password = passwordEncoder.encode(userDetails.getPassword());
        log.debug("password:{}" + password);
        if (!passwordEncoder.matches(accountBean.getAccountPwd(), password)) {
            throw new MessageException("密码不正确!");
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken(userDetails);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userDetails", userDetails);
        jsonObject.put("token", token);
        jsonObject.put("tokenHead", tokenHead);
        return jsonObject;
    }
}
