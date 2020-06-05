package com.seven.aemp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seven.aemp.bean.AccountBean;
import com.seven.aemp.common.Constant;
import com.seven.aemp.dao.AccountDao;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seven.aemp.util.CookieTools;
import org.apache.commons.lang.StringUtils;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 *  服务实现类
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

    @Autowired
    private AccountDao accountDao;

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
        if (accountDao.insert(accountBean) <= 0) throw new MessageException("操作失败!");
        return accountBean;
    }
}
