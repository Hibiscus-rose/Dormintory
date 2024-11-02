package io.renren.modules.books.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.books.dao.BooksDao;
import io.renren.modules.books.entity.BooksEntity;
import io.renren.modules.books.service.BooksService;


@Service("booksService")
public class BooksServiceImpl extends ServiceImpl<BooksDao, BooksEntity> implements BooksService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BooksEntity> page = this.page(
                new Query<BooksEntity>().getPage(params),
                new QueryWrapper<BooksEntity>()
        );

        return new PageUtils(page);
    }

}