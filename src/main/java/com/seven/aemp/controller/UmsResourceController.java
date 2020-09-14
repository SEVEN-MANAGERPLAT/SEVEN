package com.seven.aemp.controller;


import com.alibaba.fastjson.JSONObject;
import com.seven.aemp.bean.UmsMenuBean;
import com.seven.aemp.bean.UmsResourceBean;
import com.seven.aemp.common.Constant;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.security.DynamicSecurityMetadataSource;
import com.seven.aemp.service.UmsResourceService;
import com.seven.aemp.util.CommonResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



/**
 * 后台资源管理Controller
 * Created by macro on 2020/2/4.
 */
@RestController
@Api(tags = "UmsResourceController", description = "后台资源管理")
@RequestMapping("/resource")
public class UmsResourceController {

    @Autowired
    private UmsResourceService resourceService;
    @Autowired
    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;

    @ApiOperation("添加后台资源")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject create(@RequestBody UmsResourceBean umsResource) {
        int count = resourceService.create(umsResource);
        dynamicSecurityMetadataSource.clearDataSource();
        if (count > 0) {
            return CommonResultUtil.retSuccJSONObj(count);
        } else {
            return CommonResultUtil.retFailJSONObj();
        }
    }


    @PostMapping("/list")
    public JSONObject queryResourceList(@RequestBody String params) throws Exception {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        UmsResourceBean umsResourceBean = JSONObject.parseObject(params, UmsResourceBean.class);

        jsonObject.put(Constant.Result.RETDATA, resourceService.umsResourceList(umsResourceBean.getPage(), umsResourceBean.getPageSize(), umsResourceBean));

        return jsonObject;
    }

    @PostMapping(value = "/updateResource/{id}")
    public JSONObject updateResource(@PathVariable Long id, @RequestBody String params) throws MessageException {
        if (StringUtils.isBlank(params)) throw new MessageException("参数接收失败!");
        if (id<0) throw new MessageException("id接收失败!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.Result.RETCODE, Constant.Result.SUCCESS);
        jsonObject.put(Constant.Result.RETMSG, Constant.Result.SUCCESS_MSG);
        UmsResourceBean umsResourceBean = JSONObject.parseObject(params, UmsResourceBean.class);
        umsResourceBean.setId(id);
        resourceService.updateResource(umsResourceBean);
        return jsonObject;
    }
//
//    @ApiOperation("根据ID获取资源详情")
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<UmsResource> getItem(@PathVariable Long id) {
//        UmsResource umsResource = resourceService.getItem(id);
//        return CommonResult.success(umsResource);
//    }
//
//    @ApiOperation("根据ID删除后台资源")
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonResult delete(@PathVariable Long id) {
//        int count = resourceService.delete(id);
//        dynamicSecurityMetadataSource.clearDataSource();
//        if (count > 0) {
//            return CommonResult.success(count);
//        } else {
//            return CommonResult.failed();
//        }
//    }
//
//    @ApiOperation("分页模糊查询后台资源")
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<CommonPage<UmsResource>> list(@RequestParam(required = false) Long categoryId,
//                                                      @RequestParam(required = false) String nameKeyword,
//                                                      @RequestParam(required = false) String urlKeyword,
//                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
//                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
//        List<UmsResource> resourceList = resourceService.list(categoryId,nameKeyword, urlKeyword, pageSize, pageNum);
//        return CommonResult.success(CommonPage.restPage(resourceList));
//    }
//
//    @ApiOperation("查询所有后台资源")
//    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<List<UmsResource>> listAll() {
//        List<UmsResource> resourceList = resourceService.listAll();
//        return CommonResult.success(resourceList);
//    }
}
