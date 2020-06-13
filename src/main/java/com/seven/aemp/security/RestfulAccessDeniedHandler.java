package com.seven.aemp.security;

import com.alibaba.fastjson.JSONObject;
import com.seven.aemp.common.Constant;
import com.seven.aemp.util.CommonResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc:当访问接口没有权限时，自定义的返回结果
 * 【SpringBoot全局异常处理导致accessDeniedHandler不能使用】
 * @date: 2020-04-09 15:18
 * @author: dx
 * @version: 1.0
 */
//@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding(Constant.Charset.UTF8);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Access-Control-Allow-Origin", "*");
        JSONObject jsonObject = CommonResultUtil.retFailJSONObj(null, "暂无权限访问!!!");
        response.getWriter().println(jsonObject.toJSONString());
        response.getWriter().flush();
    }
}
