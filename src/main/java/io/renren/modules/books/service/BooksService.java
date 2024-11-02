package io.renren.modules.books.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.books.entity.BooksEntity;

import java.util.Map;

/**
 * 图书管理
 *
 * @author fxz
 * @email fxxz@example.com
 * @date 2024-10-19 16:50:19
 */
public interface BooksService extends IService<BooksEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

