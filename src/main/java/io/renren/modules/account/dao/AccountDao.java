package io.renren.modules.account.dao;

import io.renren.modules.account.entity.AccountEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * 账户管理
 * 
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:05:31
 */
@Mapper
public interface AccountDao extends BaseMapper<AccountEntity> {
	@Insert("insert into tb_account(id,password) values(#{id},#{password})")
    void insertAccount(AccountEntity accountEntity);
}
