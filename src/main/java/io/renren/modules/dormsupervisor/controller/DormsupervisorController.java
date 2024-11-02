package io.renren.modules.DormSupervisor.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.DormSupervisor.entity.DormsupervisorEntity;
import io.renren.modules.DormSupervisor.service.DormsupervisorService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 宿管人员管理
 *
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:27:46
 */
@RestController
@RequestMapping("DormSupervisor/dormsupervisor")
public class DormsupervisorController {
    @Autowired
    private DormsupervisorService dormsupervisorService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("DormSupervisor:dormsupervisor:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dormsupervisorService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{employeeId}")
    @RequiresPermissions("DormSupervisor:dormsupervisor:info")
    public R info(@PathVariable("employeeId") Integer employeeId){
		DormsupervisorEntity dormsupervisor = dormsupervisorService.getById(employeeId);

        return R.ok().put("dormsupervisor", dormsupervisor);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("DormSupervisor:dormsupervisor:save")
    public R save(@RequestBody DormsupervisorEntity dormsupervisor){
		dormsupervisorService.save(dormsupervisor);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("DormSupervisor:dormsupervisor:update")
    public R update(@RequestBody DormsupervisorEntity dormsupervisor){
		dormsupervisorService.updateById(dormsupervisor);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("DormSupervisor:dormsupervisor:delete")
    public R delete(@RequestBody Integer[] employeeIds){
		dormsupervisorService.removeByIds(Arrays.asList(employeeIds));

        return R.ok();
    }

}
