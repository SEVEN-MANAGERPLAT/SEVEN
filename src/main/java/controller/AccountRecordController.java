package controller;

import entity.AccountRecord;
import org.springframework.web.bind.annotation.*;
import service.AccountRecordService;

import javax.annotation.Resource;

/**
 * (AccountRecord)表控制层
 *
 * @author makejava
 * @since 2020-06-29 17:25:15
 */
@RestController
@RequestMapping("accountRecord")
public class AccountRecordController {
    /**
     * 服务对象
     */
    @Resource
    private AccountRecordService accountRecordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AccountRecord selectOne(Integer id) {
        return this.accountRecordService.queryById(id);
    }

}