package io.renren.modules.account.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.account.dao.AccountDao;
import io.renren.modules.account.entity.AccountEntity;
import io.renren.modules.account.service.AccountService;


@Service("accountService")
public class AccountServiceImpl extends ServiceImpl<AccountDao, AccountEntity> implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public void insertAccount(AccountEntity accountEntity) {
        accountDao.insertAccount(accountEntity);
    }
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key=(String)params.get("key");
        IPage<AccountEntity> page = this.page(
                new Query<AccountEntity>().getPage(params),
                new QueryWrapper<AccountEntity>().like(StringUtils.isNotBlank(key),"id", key)
        );

        return new PageUtils(page);
    }

}