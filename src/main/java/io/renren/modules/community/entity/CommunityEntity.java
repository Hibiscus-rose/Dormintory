package io.renren.modules.community.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 组团管理
 * 
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:26:45
 */
@Data
@TableName("tb_community")
public class CommunityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 组团名
	 */
	@TableId
	private String communityName;
	/**
	 * 校区
	 */
	private String campus;

}
