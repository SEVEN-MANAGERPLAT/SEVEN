package com.seven.aemp.service;

import com.seven.aemp.bean.PlantBean;
import com.baomidou.mybatisplus.extension.service.IService;
import com.seven.aemp.exception.MessageException;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mwl
 * @since 2019-11-19
 */
public interface PlantService extends IService<PlantBean> {

    //查询计划
    public List<PlantBean> queryPlant(PlantBean plantBean)throws MessageException;

    //添加计划
    public void addPlant(PlantBean plantBean)throws MessageException;

    //修改计划
    public void updatePlant(PlantBean plantBean)throws MessageException;
}
