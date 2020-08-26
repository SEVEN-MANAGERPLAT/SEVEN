package com.seven.aemp.dao;

import com.seven.aemp.bean.IdeaclickBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mwl
 * @since 2020-04-03
 */
public interface IdeaclickDao extends BaseMapper<IdeaclickBean> {

    //查询点击数
    List<IdeaclickBean> queryIdeaclick(IdeaclickBean ideaclickBean);

    //添加点击数
    int addIdeaclick(IdeaclickBean ideaclickBean);

    //更新点击数
    int updateIdeaclick(IdeaclickBean ideaclickBean);
}
