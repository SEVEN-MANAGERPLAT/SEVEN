package com.seven.aemp.controller;


import com.alibaba.fastjson.JSONObject;
import com.seven.aemp.bean.UmsMenuBean;
import com.seven.aemp.common.Constant;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.service.UmsMenuService;
import com.seven.aemp.util.CommonResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 后台菜单管理Controller
 * Created by macro on 2020/2/4.
 */
@RestController
@Api(tags = "UmsMenuController", description = "后台菜单管理")
@RequestMapping("/menu")
public class UmsMenuController {

    @Autowired
    private UmsMenuService menuService;

    @ApiOperation("添加后台菜单")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject create(@RequestBody UmsMenuBean umsMenu) {
        int count = menuService.create(umsMenu);
        if (count > 0) {
            return CommonResultUtil.retSuccJSONObj();
        } else {
            return CommonResultUtil.retFailJSONObj();
        }
    }

    @GetMapping(value = "/list/{parentId}")
    public JSONObject queryMenuList(@PathVariable Long parentId,@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer page) throws Exception {
        if (parentId<0) throw new MessageException("id接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        UmsMenuBean umsMenuBean = new UmsMenuBean();
        jsonObject.put(Constant.Result.RETDATA, menuService.umsMenuList(page, pageSize, umsMenuBean));

        return jsonObject;
    }

    @GetMapping(value = "/{id}")
    public JSONObject queryMenu(@PathVariable Long id) throws Exception {
        if (id<0) throw new MessageException("id接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        UmsMenuBean umsMenuBean = new UmsMenuBean();
        umsMenuBean.setId(id);
        jsonObject.put(Constant.Result.RETDATA, menuService.queryMenu(umsMenuBean));

        return jsonObject;
    }


    @PostMapping(value = "/update/{id}")
    public JSONObject updateMenu(@PathVariable Long id,@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        if (id<0) throw new MessageException("id接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        UmsMenuBean umsMenuBean = JSONObject.parseObject(params, UmsMenuBean.class);
        umsMenuBean.setId(id);
        menuService.updateMenu(umsMenuBean);
        return jsonObject;
    }
//
//    @ApiOperation("根据ID获取菜单详情")
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<UmsMenu> getItem(@PathVariable Long id) {
//        UmsMenu umsMenu = menuService.getItem(id);
//        return CommonResult.success(umsMenu);
//    }
//
//    @ApiOperation("根据ID删除后台菜单")
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult delete(@PathVariable Long id) {
//        int count = menuService.delete(id);
//        if (count > 0) {
//            return CommonResult.success(count);
//        } else {
//            return CommonResult.failed();
//        }
//    }
//
//    @ApiOperation("分页查询后台菜单")
//    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<CommonPage<UmsMenu>> list(@PathVariable Long parentId,
//                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
//                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
//        List<UmsMenu> menuList = menuService.list(parentId, pageSize, pageNum);
//        return CommonResult.success(CommonPage.restPage(menuList));
//    }
//
//    @ApiOperation("树形结构返回所有菜单列表")
//    @RequestMapping(value = "/treeList", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<List<UmsMenuNode>> treeList() {
//        List<UmsMenuNode> list = menuService.treeList();
//        return CommonResult.success(list);
//    }
//
//    @ApiOperation("修改菜单显示状态")
//    @RequestMapping(value = "/updateHidden/{id}", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult updateHidden(@PathVariable Long id, @RequestParam("hidden") Integer hidden) {
//        int count = menuService.updateHidden(id, hidden);
//        if (count > 0) {
//            return CommonResult.success(count);
//        } else {
//            return CommonResult.failed();
//        }
//    }
}
