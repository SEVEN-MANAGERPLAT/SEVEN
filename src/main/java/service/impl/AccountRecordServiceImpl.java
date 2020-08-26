package service.impl;

import dao.AccountRecordDao;
import entity.AccountRecord;
import org.springframework.stereotype.Service;
import service.AccountRecordService;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AccountRecord)表服务实现类
 *
 * @author makejava
 * @since 2020-06-29 17:25:14
 */
@Service("accountRecordService")
public class AccountRecordServiceImpl implements AccountRecordService {
    @Resource
    private AccountRecordDao accountRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param accrId 主键
     * @return 实例对象
     */
    @Override
    public AccountRecord queryById(Integer accrId) {
        return this.accountRecordDao.queryById(accrId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<AccountRecord> queryAllByLimit(int offset, int limit) {
        return this.accountRecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param accountRecord 实例对象
     * @return 实例对象
     */
    @Override
    public AccountRecord insert(AccountRecord accountRecord) {
        this.accountRecordDao.insert(accountRecord);
        return accountRecord;
    }

    /**
     * 修改数据
     *
     * @param accountRecord 实例对象
     * @return 实例对象
     */
    @Override
    public AccountRecord update(AccountRecord accountRecord) {
        this.accountRecordDao.update(accountRecord);
        return this.queryById(accountRecord.getAccrId());
    }

    /**
     * 通过主键删除数据
     *
     * @param accrId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer accrId) {
        return this.accountRecordDao.deleteById(accrId) > 0;
    }
}