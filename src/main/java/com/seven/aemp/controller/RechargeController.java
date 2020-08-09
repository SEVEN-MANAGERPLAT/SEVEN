package com.seven.aemp.controller;


import com.alibaba.fastjson.JSONObject;
import com.seven.aemp.bean.RechargeBean;
import com.seven.aemp.common.Constant;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.service.RechargeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 充值表 前端控制器
 * </p>
 *
 * @author mwl
 * @since 2020-08-07
 */
@Controller
@RequestMapping("/rechargeBean")
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;

    @PostMapping("/queryRecharge")
    public JSONObject queryRechargeList(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        RechargeBean rechargeBean = JSONObject.parseObject(params, RechargeBean.class);

        jsonObject.put(Constant.Result.RETDATA, rechargeService.queryRechargeList(rechargeBean));
        return jsonObject;
    }


    @PostMapping("/addRecharge")
    public JSONObject addRechargeInfo(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        RechargeBean rechargeBean = JSONObject.parseObject(params, RechargeBean.class);

        rechargeService.addRechargeInfo(rechargeBean);
        return jsonObject;
    }
}
