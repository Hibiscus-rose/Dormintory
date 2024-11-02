package io.renren.modules.students.dao;

import io.renren.modules.students.entity.StudentsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生管理
 * 
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:29:20
 */
@Mapper
public interface StudentsDao extends BaseMapper<StudentsEntity> {
	
}
