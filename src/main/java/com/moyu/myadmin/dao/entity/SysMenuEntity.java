package com.moyu.myadmin.dao.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.moyu.myadmin.utils.PublicField;
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
@TableName("sys_menu")
public class SysMenuEntity extends PublicField implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 菜单主键
	 */
	@TableId
	private String menuId;
	/**
	 * 父节点ID
	 */
	private String parentId;
	/**
	 * 菜单标题
	 */
	private String title;
	/**
	 * 图标
	 */
	private String icon;
	/**
	 * 路由地址
	 */
	private String menuPath;
	/**
	 * 排序
	 */
	private Integer indexSort;
	/**
	 * 0 启用 1 停用
	 */
	private String state;

	/**
	 * 全路径
	 */
	private String component;

}
