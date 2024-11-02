package io.renren.modules.room.dao;

import io.renren.modules.room.entity.RoomEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 宿舍房间管理
 * 
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:28:35
 */
@Mapper
public interface RoomDao extends BaseMapper<RoomEntity> {
	
}
