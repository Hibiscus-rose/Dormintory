package io.renren.modules.buildings.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 楼栋管理
 * 
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:25:15
 */
@Data
@TableName("tb_buildings")
public class BuildingsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 楼栋号
	 */
	@TableId
	private Integer buildingId;
	/**
	 * 楼栋名
	 */
	private String buildingName;
	/**
	 * 组团名
	 */
	private String communityName;
	/**
	 * 房间数量
	 */
	private Integer roomNumber;

}
