package com.moyu.myadmin.model.vo;

import java.io.Serializable;

import com.moyu.myadmin.utils.PublicField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("角色用户关联表")
public class SysUserRoleVO extends PublicField implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@ApiModelProperty("主键")
	private String userRoleId;
	/**
	 * 用户ID
	 */
	@ApiModelProperty("用户ID")
	private String userId;
	/**
	 * 角色ID
	 */
	@ApiModelProperty("角色ID")
	private String roleId;
	/**
	 * 0 启用 1 停用
	 */
	@ApiModelProperty("0 启用 1 停用")
	private String state;

}
