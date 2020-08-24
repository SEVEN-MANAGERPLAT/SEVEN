package com.seven.aemp.controller;


import com.alibaba.fastjson.JSONObject;
import com.seven.aemp.bean.AccountBean;
import com.seven.aemp.common.Constant;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.service.AccountService;
import com.seven.aemp.service.UmsRoleService;
import com.seven.aemp.util.CommonResultUtil;
import com.seven.aemp.util.JwtTokenUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping("/accountAction")
public class AccountController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UmsRoleService roleService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AccountService accountService;

    //用户登录
    //@PostMapping("/login")
    @PreAuthorize("hasAuthority('1:后台用户管理')")
    public JSONObject login(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        AccountBean accountBean = JSONObject.parseObject(params, AccountBean.class);
        jsonObject.put(Constant.Result.RETDATA, accountService.login(accountBean));
        return jsonObject;
    }

    @PostMapping("/login")
    public JSONObject loginTwo(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        AccountBean accountBean = JSONObject.parseObject(params, AccountBean.class);
        return CommonResultUtil.retSuccJSONObj(accountService.loginTwo(accountBean));
    }

    @ApiOperation(value = "刷新token")
    @GetMapping(value = "/refreshToken")
    public JSONObject refreshToken(HttpServletRequest request) throws Exception {
        String token = request.getHeader(tokenHeader);
        String refreshToken = jwtTokenUtil.refreshHeadToken(token);
        if (refreshToken == null) throw new MessageException("token已过期!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token", refreshToken);
        jsonObject.put("tokenHead", tokenHead);
        return CommonResultUtil.retSuccJSONObj(jsonObject);
    }

    @PostMapping("/queryAccount")
    public JSONObject queryAccount(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        AccountBean accountBean = JSONObject.parseObject(params, AccountBean.class);
        jsonObject.put(Constant.Result.RETDATA, accountService.queryAccount(accountBean.getPage(), accountBean.getPageSize(), accountBean));
        return jsonObject;
    }

    @GetMapping(value = "/info")
    @ApiOperation(value = "获取当前登录用户信息")
    public JSONObject getAdminInfo(Principal principal) throws Exception {
        if (principal == null) {
            return CommonResultUtil.retJSONObj(null, Constant.Result.UNAUTHORIZED_RETCODE, Constant.Result.UNAUTHORIZED_RETMSG);
        }
        String username = principal.getName();
        List<AccountBean> accountBeans = accountService.queryAccount(new AccountBean().setAccountName(username));
        if (accountBeans.isEmpty()) throw new MessageException("未查询该用户信息!");
        AccountBean accountBean = accountBeans.get(0);
        Map<String, Object> data = new HashMap<>();
        data.put("username", accountBean.getAccountName());
        data.put("roles", new String[]{"TEST"});
        data.put("menus", roleService.getMenuList(accountBean.getAccountId().longValue()));
        data.put("icon", "http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg");
        return CommonResultUtil.retSuccJSONObj(data);
    }

    @ApiOperation(value = "登出功能")
    @PostMapping(value = "/logout")
    public JSONObject logout() {
        return CommonResultUtil.retSuccJSONObj(null);
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

    //获取当前登录的用户(仅测试使用)
    @PostMapping("/getCurrentAccount")
    public JSONObject getCurrentAccount() throws Exception {
        return CommonResultUtil.retSuccJSONObj(accountService.getCurrentAccount());
    }


    @GetMapping("/queryConsumAndArrease")
    public JSONObject queryConsumAndArrease() throws Exception {
        return CommonResultUtil.retSuccJSONObj(accountService.queryConsumAndArrease());
    }

    @GetMapping("/queryAccountState")
    public JSONObject queryAccountState() throws Exception {
        return CommonResultUtil.retSuccJSONObj(accountService.queryAccountState());
    }

    //查询首页消费统计
    @PostMapping("/queryConsum")
    public JSONObject queryConsum(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        AccountBean accountBean = JSONObject.parseObject(params, AccountBean.class);
        jsonObject.put(Constant.Result.RETDATA, accountService.queryConsum(accountBean));
        return jsonObject;
    }

    //公司的消费统计
    @PostMapping("/queryFirmSummary")
    public JSONObject queryFirmSummary(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        AccountBean accountBean = JSONObject.parseObject(params, AccountBean.class);
        jsonObject.put(Constant.Result.RETDATA, accountService.queryFirmSummary(accountBean));
        return jsonObject;
    }

}
