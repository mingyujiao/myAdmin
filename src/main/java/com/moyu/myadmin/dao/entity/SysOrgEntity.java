package com.moyu.myadmin.dao.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.moyu.myadmin.utils.PublicField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 组织机构表
 * 
 * @email jiaomingyu5778@gmail.com
 * @date 2022-01-28 20:23:03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_org")
public class SysOrgEntity extends PublicField implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 机构id
	 */
	@TableId
	private String orgId;
	/**
	 * 机构编码
	 */
	private String orgCode;
	/**
	 * 机构名称
	 */
	private String orgName;
	/**
	 * 父节点ID
	 */
	private String parentId;
	/**
	 * 排序字段
	 */
	private Integer sortIndex;
	/**
	 * 0 启用 1 停用
	 */
	private String state;

}
