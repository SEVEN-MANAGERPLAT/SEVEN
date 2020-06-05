package com.seven.aemp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seven.aemp.bean.PlantBean;
import com.seven.aemp.dao.PlantDao;
import com.seven.aemp.exception.MessageException;
import com.seven.aemp.service.PlantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mwl
 * @since 2019-11-19
 */
@Service
public class PlantServiceImpl extends ServiceImpl<PlantDao, PlantBean> implements PlantService {

    @Autowired
    private PlantDao plantDao;

    @Override
    public List<PlantBean> queryPlant(PlantBean plantBean) throws MessageException {
        return plantDao.queryPlant(plantBean);
    }

    @Override
    public void addPlant(PlantBean plantBean) throws MessageException {
        System.out.println("计划1："+plantBean.toString());
        QueryWrapper<PlantBean> queryWrapper = new QueryWrapper<PlantBean>();
        queryWrapper.select("*");
        queryWrapper.eq("PLAN_NAME", plantBean.getPlanName());
        List<PlantBean> plantBeans = plantDao.selectList(queryWrapper);
        System.out.println("计划："+plantBeans.toString());
        if(plantBeans.size() > 0)throw new MessageException("计划名不能重复!");
        if (plantDao.insert(plantBean) <= 0) throw new MessageException("操作失败!");
    }

    @Override
    public void updatePlant(PlantBean plantBean) throws MessageException {
        QueryWrapper<PlantBean> queryWrapper = new QueryWrapper<PlantBean>();
        queryWrapper.select("*");
        queryWrapper.ne("plan_id", plantBean.getPlanId());
        List<PlantBean> plantBeans = plantDao.selectList(queryWrapper);
        if(plantBeans.size() > 0)throw new MessageException("计划名不能重复!");
        if (plantDao.updateById(plantBean) <= 0) throw new MessageException("操作失败!");
    }
}
