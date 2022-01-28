package com.moyu.myadmin.dao.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.moyu.myadmin.utils.PublicField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色用户关联表
 * 
 * @author jiaomingyu
 * @email jiaomingyu5778@gmail.com
 * @date 2022-01-28 11:33:14
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_user_role")
public class SysUserRoleEntity extends PublicField implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String userRoleId;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 角色ID
	 */
	private String roleId;
	/**
	 * 0 启用 1 停用
	 */
	private String state;

}
