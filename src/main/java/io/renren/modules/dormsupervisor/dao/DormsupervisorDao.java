package io.renren.modules.DormSupervisor.dao;

import io.renren.modules.DormSupervisor.entity.DormsupervisorEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 宿管人员管理
 * 
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:27:46
 */
@Mapper
public interface DormsupervisorDao extends BaseMapper<DormsupervisorEntity> {
	
}
