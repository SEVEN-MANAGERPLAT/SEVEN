package com.seven.aemp.service;

import com.seven.aemp.bean.IdeaclickBean;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mwl
 * @since 2020-04-03
 */
public interface IdeaclickService extends IService<IdeaclickBean> {

    //查询点击数
    public List<IdeaclickBean> queryIdeaclick(IdeaclickBean ideaclickBean)throws Exception;

    //添加点击数
    public void addIdeaclick(IdeaclickBean ideaclickBean)throws Exception;

    //修改点击数
    public void updateIdeaclick(IdeaclickBean ideaclickBean)throws Exception;
}
