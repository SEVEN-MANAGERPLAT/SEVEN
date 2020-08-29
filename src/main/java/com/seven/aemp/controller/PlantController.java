package com.seven.aemp.controller;


import com.alibaba.fastjson.JSONObject;
import com.seven.aemp.bean.PlantBean;
import com.seven.aemp.common.Constant;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.service.PlantService;
import com.seven.aemp.util.CommonResultUtil;
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
 * 前端控制器
 * </p>
 *
 * @author mwl
 * @since 2019-11-19
 */
@RestController
@Scope("prototype")
@RequestMapping("/plantController")
public class PlantController {

    @Autowired
    private PlantService plantService;

    /* *
     * @desc:查询计划
     * @author: mwl
     * @date: 2019/11/19 16:42
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    @PostMapping("/queryPlant")
    public JSONObject queryPlant(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        PlantBean plantBean = JSONObject.parseObject(params, PlantBean.class);
//        if (plantBean.getPage() == null && plantBean.getPageSize() == null) {
//            jsonObject.put(Constant.Result.RETDATA, plantService.queryPlant(plantBean));
//        } else {
            jsonObject.put(Constant.Result.RETDATA, plantService.queryPlanClickNum(plantBean.getPage(), plantBean.getPageSize(), plantBean));
//        }
        return jsonObject;
    }

    /* *
     * @desc:添加计划
     * @author: mwl
     * @date: 2019/11/19 16:42
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    @PostMapping("/addPlant")
    public JSONObject addPlant(@RequestBody String params) throws MessageException {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        PlantBean plantBean = JSONObject.parseObject(params, PlantBean.class);
        plantService.addPlant(plantBean);
        return jsonObject;
    }

    /* *
     * @desc:修改计划
     * @author: mwl
     * @date: 2019/11/19 16:42
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    @PostMapping("/updatePlant")
    public JSONObject updatePlant(@RequestBody String params) throws MessageException {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        PlantBean plantBean = JSONObject.parseObject(params, PlantBean.class);
        plantService.updatePlant(plantBean);
        return jsonObject;
    }

    //后台查询计划报表
    @PostMapping("/queryPlantBackReport")
    public JSONObject queryPlantBackReport(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        PlantBean plantBean = JSONObject.parseObject(params, PlantBean.class);
        return CommonResultUtil.retSuccJSONObj(plantService.queryPlantBackReport(plantBean));
    }
}
