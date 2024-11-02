package io.renren.modules.buildings.dao;

import io.renren.modules.buildings.entity.BuildingsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 楼栋管理
 * 
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:25:15
 */
@Mapper
public interface BuildingsDao extends BaseMapper<BuildingsEntity> {
	
}
