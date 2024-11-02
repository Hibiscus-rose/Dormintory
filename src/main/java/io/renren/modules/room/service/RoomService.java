package io.renren.modules.room.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.room.entity.RoomEntity;

import java.util.Map;

/**
 * 宿舍房间管理
 *
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:28:35
 */
public interface RoomService extends IService<RoomEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

