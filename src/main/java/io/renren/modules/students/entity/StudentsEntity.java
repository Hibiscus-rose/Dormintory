package io.renren.modules.students.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 学生管理
 * 
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:29:20
 */
@Data
@TableName("tb_students")
public class StudentsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 学号
	 */
	@TableId
	private Integer studentId;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 房间号
	 */
	private Integer roomId;
	/**
	 * 楼栋号
	 */
	private Integer buildingId;
	/**
	 * 电话号码
	 */
	private String phone;

}
