package com.seven.aemp.service.impl;

import com.seven.aemp.dao.CommonDao;
import com.seven.aemp.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @desc:公共服务实现类
 * @date: 2020-01-02 14:09
 * @author: dx
 * @version: 1.0
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonDao commonDao;

    @Override
    public Date queryDBTime() {
        Date date = commonDao.queryDBTime();
        return date;
    }
}
