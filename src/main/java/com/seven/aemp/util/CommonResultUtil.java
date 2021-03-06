package com.seven.aemp.util;

import com.alibaba.fastjson.JSONObject;
import com.seven.aemp.common.Constant;
import org.apache.commons.lang.StringUtils;

/**
 * @desc:接口返回结果Util
 * @date: 2020-05-19 11:56
 * @author: dx
 * @version: 1.0
 */
public class CommonResultUtil {

    //将成功结果组成JSON返回
    public static JSONObject retSuccJSONObj(Object data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        jsonObject.put(Constant.Result.RETDATA, data);
        return jsonObject;
    }

    //只返回成功结果JSON返回
    public static JSONObject retSuccJSONObj() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        return jsonObject;
    }

    //将失败结果组成JSON返回
    public static JSONObject retFailJSONObj(Object data) {
        return retFailJSONObj(data, Constant.Result.ERROR_MSG);
    }

    //只返回失败结果JSON返回
    public static JSONObject retFailJSONObj() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.ERROR);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.ERROR_MSG);
        return jsonObject;
    }

    //将失败结果组成JSON返回
    public static JSONObject retFailJSONObj(Object data, String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.ERROR);
        jsonObject.put(Constant.Result.RETMSG, StringUtils.isBlank(msg) ? Constant.Result.ERROR_MSG : msg);
        jsonObject.put(Constant.Result.RETDATA, data);
        return jsonObject;
    }

    //自定义状态码及信息
    public static JSONObject retJSONObj(Object data, String code, String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, StringUtils.isBlank(code) ? Constant.Result.ERROR : code);
        jsonObject.put(Constant.Result.RETMSG, StringUtils.isBlank(msg) ? Constant.Result.ERROR_MSG : msg);
        jsonObject.put(Constant.Result.RETDATA, data);
        return jsonObject;
    }
}
