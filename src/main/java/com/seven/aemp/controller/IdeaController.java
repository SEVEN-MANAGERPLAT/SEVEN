package com.seven.aemp.controller;


import com.alibaba.fastjson.JSONObject;
import com.seven.aemp.bean.IdeaBean;
import com.seven.aemp.common.Constant;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.service.IdeaService;
import com.seven.aemp.util.CommonResultUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
@RequestMapping("/ideaController")
public class IdeaController {

    @Autowired
    private IdeaService ideaService;

    /* *
     * @desc:查询创意
     * @author: mwl
     * @date: 2019/11/19 16:42
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    @PostMapping("/queryIdea")
    public JSONObject queryIdea(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        IdeaBean ideaBean = JSONObject.parseObject(params, IdeaBean.class);

        jsonObject.put(Constant.Result.RETDATA, ideaService.queryIdeaClickByUnitDay(ideaBean.getPage(), ideaBean.getPageSize(), ideaBean));

        return jsonObject;
    }

    /* *
     * @desc:添加创意
     * @author: mwl
     * @date: 2019/11/19 16:42
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    @PostMapping("/addIdea")
    public JSONObject addGroup(@RequestBody String params, MultipartFile[] file) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        IdeaBean ideaBean = JSONObject.parseObject(params, IdeaBean.class);
        ideaService.addIdea(ideaBean, file);
        return jsonObject;
    }

    /* *
     * @desc:修改创意
     * @author: mwl
     * @date: 2019/11/19 16:42
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    @PostMapping("/updateIdea")
    public JSONObject updateGroup(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        IdeaBean ideaBean = JSONObject.parseObject(params, IdeaBean.class);
        ideaService.updateIdea(ideaBean);
        return jsonObject;
    }

    @PostMapping("/updateClickIdea")
    public JSONObject updateClickGroup(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        IdeaBean ideaBean = JSONObject.parseObject(params, IdeaBean.class);
        jsonObject.put(Constant.Result.RETDATA, ideaService.updateCilckIdea(ideaBean));
        return jsonObject;
    }

    //更新审核状态
    @PostMapping("/updateCheckState")
    public JSONObject updateCheckState(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        IdeaBean ideaBean = JSONObject.parseObject(params, IdeaBean.class);
        ideaService.updateCheckState(ideaBean);
        return jsonObject;
    }

    //广告创意报表【后台管理】
    @PostMapping("/queryIdeaBackReport")
    public JSONObject queryIdeaBackReport(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        return CommonResultUtil.retSuccJSONObj(ideaService.queryIdeaBackReport(JSONObject.parseObject(params, IdeaBean.class)));
    }
}
