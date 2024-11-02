package io.renren.modules.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.account.entity.AccountEntity;

import java.util.Map;

/**
 * 账户管理
 *
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:05:31
 */
public interface AccountService extends IService<AccountEntity> {
    void insertAccount(AccountEntity accountEntity);
    PageUtils queryPage(Map<String, Object> params);
}

