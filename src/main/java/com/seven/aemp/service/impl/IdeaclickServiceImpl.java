package com.seven.aemp.service.impl;

import com.seven.aemp.bean.IdeaclickBean;
import com.seven.aemp.dao.IdeaclickDao;
import com.seven.aemp.service.IdeaclickService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mwl
 * @since 2020-04-03
 */
@Service
public class IdeaclickServiceImpl extends ServiceImpl<IdeaclickDao, IdeaclickBean> implements IdeaclickService {


    @Override
    public List<IdeaclickBean> queryIdeaclick(IdeaclickBean ideaclickBean) throws Exception {
        return null;
    }

    @Override
    public void addIdeaclick(IdeaclickBean ideaclickBean) throws Exception {

    }

    @Override
    public void updateIdeaclick(IdeaclickBean ideaclickBean) throws Exception {

    }
}
