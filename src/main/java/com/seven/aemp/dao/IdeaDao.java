package com.seven.aemp.dao;

import com.seven.aemp.bean.IdeaBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mwl
 * @since 2019-11-19
 */
@Mapper
public interface IdeaDao extends BaseMapper<IdeaBean> {

    //查询创意，一段时间内汇总点击量
    List<IdeaBean> queryIdea(IdeaBean ideaBean);

    //查询创意，一段时间内单日点击量数据
    List<IdeaBean> queryIdeaClickByUnitDay(IdeaBean ideaBean);

    //添加创意
    int addIdea(IdeaBean ideaBean);

    int updateClickIdea(IdeaBean ideaBean);
}
