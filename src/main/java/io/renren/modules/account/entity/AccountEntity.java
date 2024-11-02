package io.renren.modules.account.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 账户管理
 * 
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:05:31
 */
@Data
@TableName("tb_account")
public class AccountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 账户名
	 */
	@TableId
	private String id;
	/**
	 * 密码
	 */
	private String password;

}
