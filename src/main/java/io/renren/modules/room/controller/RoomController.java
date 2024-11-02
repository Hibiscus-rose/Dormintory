package io.renren.modules.room.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.room.entity.RoomEntity;
import io.renren.modules.room.service.RoomService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 宿舍房间管理
 *
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:28:35
 */
@RestController
@RequestMapping("room/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("room:room:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = roomService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{roomId}")
    @RequiresPermissions("room:room:info")
    public R info(@PathVariable("roomId") Integer roomId){
		RoomEntity room = roomService.getById(roomId);

        return R.ok().put("room", room);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("room:room:save")
    public R save(@RequestBody RoomEntity room){
		roomService.save(room);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("room:room:update")
    public R update(@RequestBody RoomEntity room){
		roomService.updateById(room);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("room:room:delete")
    public R delete(@RequestBody Integer[] roomIds){
		roomService.removeByIds(Arrays.asList(roomIds));

        return R.ok();
    }

}
