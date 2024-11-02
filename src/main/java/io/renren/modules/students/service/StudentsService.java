package io.renren.modules.students.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.students.entity.StudentsEntity;

import java.util.Map;

/**
 * 学生管理
 *
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:29:20
 */
public interface StudentsService extends IService<StudentsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

