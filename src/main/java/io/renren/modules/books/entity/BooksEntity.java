package io.renren.modules.books.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 图书管理
 * 
 * @author fxz
 * @email fxxz@example.com
 * @date 2024-10-19 16:50:19
 */
@Data
@TableName("tb_books")
public class BooksEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 书名
	 */
	private String name;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 介绍
	 */
	private String intro;
	/**
	 * 价格
	 */
	private BigDecimal price;
	/**
	 * 数量
	 */
	private Integer num;

}
