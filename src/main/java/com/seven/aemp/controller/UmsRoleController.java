package com.seven.aemp.controller;


import com.alibaba.fastjson.JSONObject;
import com.seven.aemp.bean.UmsMenuBean;
import com.seven.aemp.bean.UmsRoleBean;
import com.seven.aemp.common.Constant;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.service.UmsRoleService;
import com.seven.aemp.util.CommonResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 后台用户角色管理
 * Created by macro on 2018/9/30.
 */
@RestController
@Api(tags = "UmsRoleController", description = "后台用户角色管理")
@RequestMapping("/role")
public class UmsRoleController {
    @Autowired
    private UmsRoleService roleService;

    @ApiOperation("添加角色")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject create(@RequestBody UmsRoleBean role) {
        int count = roleService.create(role);
        if (count > 0) {
            return CommonResultUtil.retSuccJSONObj();
        }
        return CommonResultUtil.retFailJSONObj();
    }


    @PostMapping("/queryRoleList")
    public JSONObject queryRoleList(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        UmsRoleBean umsRoleBean = JSONObject.parseObject(params, UmsRoleBean.class);

        jsonObject.put(Constant.Result.RETDATA, roleService.umsRoleList(umsRoleBean.getPage(), umsRoleBean.getPageSize(), umsRoleBean));

        return jsonObject;
    }

    @PostMapping("/updateRole")
    public JSONObject updateRole(@RequestBody String params) throws MessageException {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        UmsRoleBean umsRoleBean = JSONObject.parseObject(params, UmsRoleBean.class);
        roleService.updateRole(umsRoleBean);
        return jsonObject;
    }
//
//    @ApiOperation("修改角色状态")
//    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
//    @ResponseBody
//    public JSONObject updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
//        UmsRole umsRole = new UmsRole();
//        umsRole.setStatus(status);
//        int count = roleService.update(id, umsRole);
//        if (count > 0) {
//            return CommonResultUtil.success(count);
//        }
//        return CommonResultUtil.failed();
//    }
//
//    @ApiOperation("获取角色相关菜单")
//    @RequestMapping(value = "/listMenu/{roleId}", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<List<UmsMenu>> listMenu(@PathVariable Long roleId) {
//        List<UmsMenu> roleList = roleService.listMenu(roleId);
//        return CommonResultUtil.success(roleList);
//    }
//
//    @ApiOperation("获取角色相关资源")
//    @RequestMapping(value = "/listResource/{roleId}", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<List<UmsResource>> listResource(@PathVariable Long roleId) {
//        List<UmsResource> roleList = roleService.listResource(roleId);
//        return CommonResultUtil.success(roleList);
//    }
//
//    @ApiOperation("给角色分配菜单")
//    @RequestMapping(value = "/allocMenu", method = RequestMethod.POST)
//    @ResponseBody
//    public JSONObject allocMenu(@RequestParam Long roleId, @RequestParam List<Long> menuIds) {
//        int count = roleService.allocMenu(roleId, menuIds);
//        return CommonResultUtil.success(count);
//    }
//
//    @ApiOperation("给角色分配资源")
//    @RequestMapping(value = "/allocResource", method = RequestMethod.POST)
//    @ResponseBody
//    public JSONObject allocResource(@RequestParam Long roleId, @RequestParam List<Long> resourceIds) {
//        int count = roleService.allocResource(roleId, resourceIds);
//        return CommonResultUtil.success(count);
//    }

}
