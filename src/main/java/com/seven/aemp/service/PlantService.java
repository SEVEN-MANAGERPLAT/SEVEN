package com.seven.aemp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seven.aemp.bean.PlantBean;
import com.baomidou.mybatisplus.extension.service.IService;
import com.seven.aemp.exception.MessageException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author mwl
 * @since 2019-11-19
 */
public interface PlantService extends IService<PlantBean> {

    //查询计划
    public List<PlantBean> queryPlant(PlantBean plantBean) throws Exception;

    public Page<PlantBean> queryPlant(String page, String pageSize, PlantBean plantBean) throws Exception;

    //添加计划
    public void addPlant(PlantBean plantBean) throws MessageException;

    //修改计划
    public void updatePlant(PlantBean plantBean) throws MessageException;

    //后台查询计划报表
    public IPage queryPlantBackReport(PlantBean plantBean) throws Exception;

    //查询计划点击量
    public Page<PlantBean> queryPlanClickNum(String page, String pageSize, PlantBean plantBean) throws Exception;

}
