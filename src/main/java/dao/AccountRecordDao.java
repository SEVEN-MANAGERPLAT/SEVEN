package dao;

import entity.AccountRecord;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (AccountRecord)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-29 17:25:11
 */
public interface AccountRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param accrId 主键
     * @return 实例对象
     */
    AccountRecord queryById(Integer accrId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AccountRecord> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param accountRecord 实例对象
     * @return 对象列表
     */
    List<AccountRecord> queryAll(AccountRecord accountRecord);

    /**
     * 新增数据
     *
     * @param accountRecord 实例对象
     * @return 影响行数
     */
    int insert(AccountRecord accountRecord);

    /**
     * 修改数据
     *
     * @param accountRecord 实例对象
     * @return 影响行数
     */
    int update(AccountRecord accountRecord);

    /**
     * 通过主键删除数据
     *
     * @param accrId 主键
     * @return 影响行数
     */
    int deleteById(Integer accrId);

}