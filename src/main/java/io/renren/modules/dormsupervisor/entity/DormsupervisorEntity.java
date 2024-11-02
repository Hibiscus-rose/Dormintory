package io.renren.modules.DormSupervisor.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 宿管人员管理
 * 
 * @author hzh
 * @email hzh@example.com
 * @date 2024-10-19 20:27:46
 */
@Data
@TableName("tb_dormsupervisor")
public class DormsupervisorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 职工号
	 */
	@TableId
	private Integer employeeId;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 电话号码
	 */
	private String phone;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 负责楼栋号
	 */
	private Integer buildingId;

}
