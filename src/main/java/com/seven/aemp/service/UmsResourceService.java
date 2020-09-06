package com.seven.aemp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.seven.aemp.bean.AccountBean;
import com.seven.aemp.bean.UmsResourceBean;

import java.util.List;

/**
 * @desc:资源Service
 * @date: 2020-06-11 11:38
 * @author: dx
 * @version: 1.0
 */
public interface UmsResourceService extends IService<UmsResourceBean> {

    //查询
    List<UmsResourceBean> queryUmsResource(UmsResourceBean umsResourceBean);

    List<UmsResourceBean> queryUmsResourceByAdminId(AccountBean accountBean);

    /**
     * 添加资源
     */
    int create(UmsResourceBean umsResource);

    //查询资源
    public Page<UmsResourceBean> umsResourceList(String page, String pageSize, UmsResourceBean umsResourceBean) throws Exception;
}
