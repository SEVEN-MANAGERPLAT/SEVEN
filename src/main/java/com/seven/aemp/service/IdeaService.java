package com.seven.aemp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seven.aemp.bean.IdeaBean;
import com.baomidou.mybatisplus.extension.service.IService;
import com.seven.aemp.exception.MessageException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author mwl
 * @since 2019-11-19
 */
public interface IdeaService extends IService<IdeaBean> {

    //查询创意列表
    public List<IdeaBean> queryIdea(IdeaBean ideaBean) throws Exception;

    public Page<IdeaBean> queryIdea(String page, String pageSize, IdeaBean ideaBean) throws Exception;

    //添加创意
    public void addIdea(IdeaBean ideaBean, MultipartFile[] file) throws Exception;

    //修改创意
    public void updateIdea(IdeaBean ideaBean) throws Exception;

    //修改创意点击数
    public IdeaBean updateCilckIdea(IdeaBean ideaBean) throws Exception;

    //修改审核状态
    public void updateCheckState(IdeaBean ideaBean) throws Exception;

    //查询创意点击量
    public Page<IdeaBean> queryIdeaClickByUnitDay(String page, String pageSize, IdeaBean ideaBean) throws Exception;

    //广告创意报表【后台管理】
    public IPage queryIdeaBackReport(IdeaBean ideaBean) throws Exception;
}
