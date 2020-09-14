package com.seven.aemp.controller;

import com.alibaba.fastjson.JSONObject;
import com.seven.aemp.bean.UmsResourceCategoryBean;
import com.seven.aemp.common.Constant;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.service.UmsResourceCategoryService;
import com.seven.aemp.util.CommonResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台资源分类管理Controller
 * Created by macro on 2020/2/5.
 */
@RestController
@Api(tags = "UmsResourceCategoryController", description = "后台资源分类管理")
@RequestMapping("/resourceCategory")
public class UmsResourceCategoryController {
    @Autowired
    private UmsResourceCategoryService resourceCategoryService;


    @ApiOperation("添加后台菜单")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject create(@RequestBody UmsResourceCategoryBean resourceCategoryBean) {
        int count = resourceCategoryService.create(resourceCategoryBean);
        if (count > 0) {
            return CommonResultUtil.retSuccJSONObj();
        } else {
            return CommonResultUtil.retFailJSONObj();
        }
    }

    @ApiOperation("查询所有后台资源分类")
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject listAll() {
        List<UmsResourceCategoryBean> resourceList = resourceCategoryService.listAll();
        return CommonResultUtil.retSuccJSONObj(resourceList);
    }

    @PostMapping(value = "/updateResourceCategory/{id}")
    public JSONObject updateResourceCategory(@PathVariable Long id, @RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        if (id<0) throw new MessageException("id接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        UmsResourceCategoryBean umsResourceCategoryBean = JSONObject.parseObject(params, UmsResourceCategoryBean.class);
        umsResourceCategoryBean.setId(id);
        resourceCategoryService.updateResourceCategory(umsResourceCategoryBean);
        return jsonObject;
    }
//
//    @ApiOperation("添加后台资源分类")
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult create(@RequestBody UmsResourceCategory umsResourceCategory) {
//        int count = resourceCategoryService.create(umsResourceCategory);
//        if (count > 0) {
//            return CommonResult.success(count);
//        } else {
//            return CommonResult.failed();
//        }
//    }
//
//    @ApiOperation("修改后台资源分类")
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult update(@PathVariable Long id,
//                               @RequestBody UmsResourceCategory umsResourceCategory) {
//        int count = resourceCategoryService.update(id, umsResourceCategory);
//        if (count > 0) {
//            return CommonResult.success(count);
//        } else {
//            return CommonResult.failed();
//        }
//    }
//
//    @ApiOperation("根据ID删除后台资源")
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult delete(@PathVariable Long id) {
//        int count = resourceCategoryService.delete(id);
//        if (count > 0) {
//            return CommonResult.success(count);
//        } else {
//            return CommonResult.failed();
//        }
//    }
}
