package io.renren.modules.buildings.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.buildings.entity.BuildingsEntity;
import io.renren.modules.buildings.service.BuildingsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 楼栋管理
 *
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:25:15
 */
@RestController
@RequestMapping("buildings/buildings")
public class BuildingsController {
    @Autowired
    private BuildingsService buildingsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("buildings:buildings:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = buildingsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{buildingId}")
    @RequiresPermissions("buildings:buildings:info")
    public R info(@PathVariable("buildingId") Integer buildingId){
		BuildingsEntity buildings = buildingsService.getById(buildingId);

        return R.ok().put("buildings", buildings);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("buildings:buildings:save")
    public R save(@RequestBody BuildingsEntity buildings){
		buildingsService.save(buildings);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("buildings:buildings:update")
    public R update(@RequestBody BuildingsEntity buildings){
		buildingsService.updateById(buildings);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("buildings:buildings:delete")
    public R delete(@RequestBody Integer[] buildingIds){
		buildingsService.removeByIds(Arrays.asList(buildingIds));

        return R.ok();
    }

}
