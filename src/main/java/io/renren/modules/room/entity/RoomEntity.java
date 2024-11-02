package io.renren.modules.room.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 宿舍房间管理
 * 
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:28:35
 */
@Data
@TableName("tb_room")
public class RoomEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 宿舍号
	 */
	@TableId
	private Integer roomId;
	/**
	 * 楼栋号
	 */
	private Integer buildingId;
	/**
	 * 费用/年
	 */
	private Integer perYearFee;
	/**
	 * 容量/人
	 */
	private Integer roomCapacity;
	/**
	 * 面积/m²
	 */
	private Integer area;

}
