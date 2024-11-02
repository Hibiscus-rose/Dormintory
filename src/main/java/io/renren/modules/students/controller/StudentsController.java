package io.renren.modules.students.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.students.entity.StudentsEntity;
import io.renren.modules.students.service.StudentsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 学生管理
 *
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:29:20
 */
@RestController
@RequestMapping("students/students")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("students:students:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = studentsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{studentId}")
    @RequiresPermissions("students:students:info")
    public R info(@PathVariable("studentId") Integer studentId){
		StudentsEntity students = studentsService.getById(studentId);

        return R.ok().put("students", students);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("students:students:save")
    public R save(@RequestBody StudentsEntity students){
		studentsService.save(students);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("students:students:update")
    public R update(@RequestBody StudentsEntity students){
		studentsService.updateById(students);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("students:students:delete")
    public R delete(@RequestBody Integer[] studentIds){
		studentsService.removeByIds(Arrays.asList(studentIds));

        return R.ok();
    }

}
