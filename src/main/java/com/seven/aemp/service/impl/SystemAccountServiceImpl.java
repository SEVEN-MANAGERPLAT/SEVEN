package com.seven.aemp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.seven.aemp.bean.AccountBean;
import com.seven.aemp.bean.SystemAccountBean;
import com.seven.aemp.common.Constant;
import com.seven.aemp.dao.SystemAccountDao;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.service.SystemAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seven.aemp.util.CookieTools;
import org.apache.commons.lang.StringUtils;
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
 * @since 2020-03-31
 */
@Service
public class SystemAccountServiceImpl extends ServiceImpl<SystemAccountDao, SystemAccountBean> implements SystemAccountService {

    @Value("${tokenLife}")
    private int tokenLife;

    @Value("${accountLife}")
    private int accountLife;


    @Autowired
    private SystemAccountDao systemAccountDao;

    @Override
    public List<SystemAccountBean> querySystemAccount(SystemAccountBean systemAccountBean) {
        return systemAccountDao.querySystemAccount(systemAccountBean);
    }

    @Override
    public JSONObject login(SystemAccountBean systemAccountBean) throws Exception {
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isBlank(systemAccountBean.getSysAccount())) throw new MessageException("账号不能为空!");
        if (StringUtils.isBlank(systemAccountBean.getSysPwd())) throw new MessageException("密码不能为空!");
        List<SystemAccountBean> systemAccountBeans = querySystemAccount(systemAccountBean);
        SystemAccountBean bean = null;
        if (systemAccountBeans.size() <= 0) {
            throw new MessageException("账号名或命名错误!");
        } else {
            bean = systemAccountBeans.get(0);
            bean.setSysPwd("");
            if ("0".equals(bean.getIsUse()) || "false".equals(bean.getIsUse()))
                throw new MessageException("该账号已被停用，请联系管理员!");
            HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            String accessToken = URLEncoder.encode(bean.getSysAccount().concat("604800"), Constant.Charset.UTF8);
            jsonObject.put("accessToken", accessToken);
            jsonObject.put("accountData", bean);
            CookieTools.addCookie(response, "accessToken", accessToken, tokenLife);
            CookieTools.addCookie(response, "accountData", URLEncoder.encode(JSON.toJSONString(bean), Constant.Charset.UTF8), accountLife);
        }
        return jsonObject;
    }

    @Override
    public void updateSystemAccount(SystemAccountBean systemAccountBean) throws Exception {
        if (StringUtils.isBlank(systemAccountBean.getSysAccount())) throw new MessageException("账号不能为空!");
        if (StringUtils.isBlank(systemAccountBean.getSysPwd())) throw new MessageException("密码不能为空!");
        if (systemAccountDao.updateSystemAccount(systemAccountBean) <= 0) throw new MessageException("操作失败!");
    }

    @Override
    public SystemAccountBean addSystemAccount(SystemAccountBean systemAccountBean) throws Exception {
        if (StringUtils.isBlank(systemAccountBean.getSysAccount())) throw new MessageException("账号不能为空!");
        if (StringUtils.isBlank(systemAccountBean.getSysPwd())) throw new MessageException("密码不能为空!");
        if (systemAccountDao.insert(systemAccountBean) <= 0) throw new MessageException("操作失败!");
        return systemAccountBean;
    }
}
