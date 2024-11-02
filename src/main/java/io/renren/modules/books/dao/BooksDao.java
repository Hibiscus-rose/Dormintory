package io.renren.modules.books.dao;

import io.renren.modules.books.entity.BooksEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 图书管理
 * 
 * @author fxz
 * @email fxxz@example.com
 * @date 2024-10-19 16:50:19
 */
@Mapper
public interface BooksDao extends BaseMapper<BooksEntity> {
	
}
