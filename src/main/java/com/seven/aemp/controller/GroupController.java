package com.seven.aemp.controller;


import com.alibaba.fastjson.JSONObject;
import com.seven.aemp.bean.GroupBean;
import com.seven.aemp.common.Constant;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.service.GroupService;
import com.seven.aemp.util.CommonResultUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/groupController")
public class GroupController {

    @Autowired
    private GroupService groupService;

    /* *
     * @desc:查询组计划
     * @author: mwl
     * @date: 2019/11/19 16:42
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    @PostMapping("/queryGroup")
    public JSONObject queryGroup(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        GroupBean groupBean = JSONObject.parseObject(params, GroupBean.class);
        if (groupBean.getPage() == null && groupBean.getPageSize() == null) {
            jsonObject.put(Constant.Result.RETDATA, groupService.queryGroup(groupBean));
        } else {
            jsonObject.put(Constant.Result.RETDATA, groupService.queryGroupIdeaClickByUnitDay(groupBean.getPage(), groupBean.getPageSize(), groupBean));
        }
        return jsonObject;
    }

    /* *
     * @desc:添加组计划
     * @author: mwl
     * @date: 2019/11/19 16:42
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    @PostMapping("/addGroup")
    public JSONObject addGroup(@RequestBody String params) throws MessageException {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        GroupBean groupMBean = JSONObject.parseObject(params, GroupBean.class);
        groupService.addGroup(groupMBean);
        return jsonObject;
    }

    /* *
     * @desc:修改组计划
     * @author: mwl
     * @date: 2019/11/19 16:42
     * @param params :
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @version: 1.0
     **/
    @PostMapping("/updateGroup")
    public JSONObject updateGroup(@RequestBody String params) throws MessageException {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        GroupBean groupMBean = JSONObject.parseObject(params, GroupBean.class);
        groupService.updateGroup(groupMBean);
        return jsonObject;
    }

    //后台查询组报表
    @PostMapping("/queryGroupBackReport")
    public JSONObject queryGroupBackReport(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        GroupBean groupMBean = JSONObject.parseObject(params, GroupBean.class);
        return CommonResultUtil.retSuccJSONObj(groupService.queryGroupBackReport(groupMBean));
    }
}
