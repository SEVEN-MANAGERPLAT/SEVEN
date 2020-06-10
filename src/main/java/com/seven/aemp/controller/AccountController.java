package com.seven.aemp.controller;


import com.alibaba.fastjson.JSONObject;
import com.seven.aemp.bean.AccountBean;
import com.seven.aemp.common.Constant;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.service.AccountService;
import com.seven.aemp.util.CommonResultUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mwl
 * @since 2019-11-19
 */
@RestController
@Scope("prototype")
@RequestMapping("/accountAction")
public class AccountController {
    @Autowired
    private AccountService accountService;

    //用户登录
    @PostMapping("/login")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public JSONObject login(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        AccountBean accountBean = JSONObject.parseObject(params, AccountBean.class);
        jsonObject.put(Constant.Result.RETDATA, accountService.login(accountBean));
        return jsonObject;
    }

    @PostMapping("/loginTwo")
    public JSONObject loginTwo(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        AccountBean accountBean = JSONObject.parseObject(params, AccountBean.class);
        return CommonResultUtil.retSuccJSONObj(accountService.loginTwo(accountBean));
    }

    @PostMapping("/queryAccount")
    public JSONObject queryAccount(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        AccountBean accountBean = JSONObject.parseObject(params, AccountBean.class);
        jsonObject.put(Constant.Result.RETDATA, accountService.queryAccount(accountBean));
        return jsonObject;
    }

    //修改用户信息
    @PostMapping("/updateAccount")
    public JSONObject updateAccount(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        AccountBean accountBean = JSONObject.parseObject(params, AccountBean.class);
        accountService.updateAccount(accountBean);
        return jsonObject;
    }

    //注册用户信息
    @PostMapping("/addAccount")
    public JSONObject addAccount(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        AccountBean accountBean = JSONObject.parseObject(params, AccountBean.class);
        jsonObject.put(Constant.Result.RETDATA, accountService.addAccount(accountBean));
        return jsonObject;
    }
}
