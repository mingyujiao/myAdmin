package com.moyu.myadmin.model.vo;

import java.io.Serializable;
import com.moyu.myadmin.utils.PublicField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 组织机构表
 * 
 * @email jiaomingyu5778@gmail.com
 * @date 2022-01-28 20:23:03
 */
@Data
@ApiModel("组织机构表")
@EqualsAndHashCode(callSuper = true)
public class SysOrgVO extends PublicField implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 机构id
	 */
	@ApiModelProperty("机构id")
	private String orgId;
	/**
	 * 机构编码
	 */
	@ApiModelProperty("机构编码")
	private String orgCode;
	/**
	 * 机构名称
	 */
	@ApiModelProperty("机构名称")
	private String orgName;
	/**
	 * 父节点ID
	 */
	@ApiModelProperty("父节点ID")
	private String parentId;
	/**
	 * 排序字段
	 */
	@ApiModelProperty("排序字段")
	private Integer sortIndex;
	/**
	 * 0 启用 1 停用
	 */
	@ApiModelProperty("0 启用 1 停用")
	private String state;

}
