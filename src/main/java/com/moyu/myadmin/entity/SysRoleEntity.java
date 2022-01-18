package com.moyu.myadmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 角色表
    */
@ApiModel(value="角色表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_role")
public class SysRoleEntity implements Serializable {
    /**
     * 角色id
     */
    @TableId(value = "role_id", type = IdType.INPUT)
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
     * 开始生效日期
     */
    @TableField(value = "start_active_date")
    @ApiModelProperty(value="开始生效日期")
    private Date startActiveDate;

    /**
     * 截至生效日期
     */
    @TableField(value = "end_active_date")
    @ApiModelProperty(value="截至生效日期")
    private Date endActiveDate;

    /**
     * 0 启用 1 停用
     */
    @TableField(value = "\"state\"")
    @ApiModelProperty(value="0 启用 1 停用")
    private String state;

    private static final long serialVersionUID = 1L;

    public static final String COL_ROLE_ID = "role_id";

    public static final String COL_ROLE_CODE = "role_code";

    public static final String COL_ROLE_NAME = "role_name";

    public static final String COL_ROLE_DESCRIPTION = "role_description";

    public static final String COL_START_ACTIVE_DATE = "start_active_date";

    public static final String COL_END_ACTIVE_DATE = "end_active_date";

    public static final String COL_STATE = "state";
}