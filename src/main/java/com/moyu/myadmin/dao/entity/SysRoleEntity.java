package com.moyu.myadmin.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.moyu.myadmin.utils.PublicField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import lombok.*;

/**
    * 角色表
    */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="角色表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_role")
public class SysRoleEntity extends PublicField implements Serializable {
    /**
     * 角色id
     */
    @TableId(value = "role_id")
    @ApiModelProperty(value="角色id")
    private String roleId;

    /**
     * 角色编码
     */
    @TableField(value = "role_code")
    @ApiModelProperty(value="角色编码")
    private String roleCode;

    /**
     * 角色名称
     */
    @TableField(value = "role_name")
    @ApiModelProperty(value="角色名称")
    private String roleName;

    /**
     * 角色描述
     */
    @TableField(value = "role_description")
    @ApiModelProperty(value="角色描述")
    private String roleDescription;

    /**
     * 0 启用 1 停用
     */
    @TableField(value = "state")
    @ApiModelProperty(value="0 启用 1 停用")
    private String state;

    private static final long serialVersionUID = 1L;


}