package service;

import entity.AccountRecord;

import java.util.List;

/**
 * (AccountRecord)表服务接口
 *
 * @author makejava
 * @since 2020-06-29 17:25:13
 */
public interface AccountRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param accrId 主键
     * @return 实例对象
     */
    AccountRecord queryById(Integer accrId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AccountRecord> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param accountRecord 实例对象
     * @return 实例对象
     */
    AccountRecord insert(AccountRecord accountRecord);

    /**
     * 修改数据
     *
     * @param accountRecord 实例对象
     * @return 实例对象
     */
    AccountRecord update(AccountRecord accountRecord);

    /**
     * 通过主键删除数据
     *
     * @param accrId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer accrId);

}