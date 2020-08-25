package com.seven.aemp.dao;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seven.aemp.bean.IdeaBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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
    List<IdeaBean> queryIdea(@Param("idea") IdeaBean ideaBean);

    //分页创意查询
    List<IdeaBean> queryIdea(Page<IdeaBean> result, @Param("idea") IdeaBean ideaBean);

    //查询创意，一段时间内单日点击量数据
    List<IdeaBean> queryIdeaClickByUnitDay(Page<IdeaBean> result, @Param("idea") IdeaBean ideaBean);

    //添加创意
    int addIdea(IdeaBean ideaBean);

    //更新点击数
    int updateClickIdea(IdeaBean ideaBean);

//    更新审核状态
    int updateCheckState(IdeaBean ideaBean);

    //广告创意报表【后台管理】
    IPage<IdeaBean> queryIdeaBackReport(@Param("page") IPage page, @Param("ideaBean") IdeaBean ideaBean);
}
