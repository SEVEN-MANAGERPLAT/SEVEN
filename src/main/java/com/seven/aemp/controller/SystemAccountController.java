package com.seven.aemp.controller;


import com.alibaba.fastjson.JSONObject;
import com.seven.aemp.bean.SystemAccountBean;
import com.seven.aemp.common.Constant;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.service.SystemAccountService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mwl
 * @since 2020-03-31
 */
@RestController
@Scope("prototype")
@RequestMapping("/systemAccount")
public class SystemAccountController {
    @Autowired
    private SystemAccountService systemAccountService;

    //用户登录
    @PostMapping("/login")
    public JSONObject login(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        SystemAccountBean systemAccountBean = JSONObject.parseObject(params, SystemAccountBean.class);
        jsonObject.put(Constant.Result.RETDATA, systemAccountService.login(systemAccountBean));
        return jsonObject;
    }


    @PostMapping("/queryAccount")
    public JSONObject queryAccount(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        SystemAccountBean systemAccountBean = JSONObject.parseObject(params, SystemAccountBean.class);
        jsonObject.put(Constant.Result.RETDATA, systemAccountService.querySystemAccount(systemAccountBean));
        return jsonObject;
    }

    //修改用户信息
    @PostMapping("/updateAccount")
    public JSONObject updateAccount(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        SystemAccountBean systemAccountBean = JSONObject.parseObject(params, SystemAccountBean.class);
        systemAccountService.updateSystemAccount(systemAccountBean);
        return jsonObject;
    }

    //注册用户信息
    @PostMapping("/addAccount")
    public JSONObject addAccount(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        SystemAccountBean systemAccountBean = JSONObject.parseObject(params, SystemAccountBean.class);
        jsonObject.put(Constant.Result.RETDATA, systemAccountService.addSystemAccount(systemAccountBean));
        return jsonObject;
    }
}
