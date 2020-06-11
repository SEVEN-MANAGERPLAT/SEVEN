package com.seven.aemp.security;

import com.alibaba.fastjson.JSONObject;
import com.seven.aemp.common.Constant;
import com.seven.aemp.util.CommonResultUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc:当未登录或者token失效访问接口时，自定义的返回结果
 * @date: 2020-04-09 15:21
 * @author: dx
 * @version: 1.0
 */
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding(Constant.Charset.UTF8);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Access-Control-Allow-Origin", "*");
        JSONObject jsonObject = CommonResultUtil.retFailJSONObj(null, "未登录或token失效!");
        response.getWriter().println(jsonObject.toJSONString());
        response.getWriter().flush();
    }
}
