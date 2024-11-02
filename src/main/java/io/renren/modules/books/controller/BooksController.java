package io.renren.modules.books.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.books.entity.BooksEntity;
import io.renren.modules.books.service.BooksService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 图书管理
 *
 * @author fxz
 * @email fxxz@example.com
 * @date 2024-10-19 16:50:19
 */
@RestController
@RequestMapping("books/books")
public class BooksController {
    @Autowired
    private BooksService booksService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("books:books:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = booksService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("books:books:info")
    public R info(@PathVariable("id") Long id){
		BooksEntity books = booksService.getById(id);

        return R.ok().put("books", books);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("books:books:save")
    public R save(@RequestBody BooksEntity books){
		booksService.save(books);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("books:books:update")
    public R update(@RequestBody BooksEntity books){
		booksService.updateById(books);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("books:books:delete")
    public R delete(@RequestBody Long[] ids){
		booksService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
