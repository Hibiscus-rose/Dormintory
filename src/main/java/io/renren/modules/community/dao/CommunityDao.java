package io.renren.modules.community.dao;

import java.util.List;

import io.renren.modules.community.entity.CommunityEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 组团管理
 * 
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:26:45
 */
@Mapper
public interface CommunityDao extends BaseMapper<CommunityEntity> {
    @Select("select * from tb_community")
	public List<CommunityEntity> findAll();
}
