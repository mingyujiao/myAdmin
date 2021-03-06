package com.moyu.myadmin.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.moyu.myadmin.utils.PublicField;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单管理
 * 
 * @email jiaomingyu5778@gmail.com
 * @date 2022-02-06 18:17:03
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("菜单管理")
public class SysMenuDTO extends PublicField implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 菜单主键
	 */
	@ApiModelProperty("菜单主键")
	private String menuId;
	/**
	 * 父节点ID
	 */
	@ApiModelProperty("父节点ID")
	private String parentId;
	/**
	 * 菜单标题
	 */
	@ApiModelProperty("菜单标题")
	private String title;
	/**
	 * 图标
	 */
	@ApiModelProperty("图标")
	private String icon;
	/**
	 * 路由地址
	 */
	@ApiModelProperty("路由地址")
	private String menuPath;
	/**
	 * 排序
	 */
	@ApiModelProperty("排序")
	private Integer sortIndex;
	/**
	 * 0 启用 1 停用
	 */
	@ApiModelProperty("0 启用 1 停用")
	private String state;

	/**
	 * 全路径
	 */
	@ApiModelProperty("全路径")
	private String component;

}
