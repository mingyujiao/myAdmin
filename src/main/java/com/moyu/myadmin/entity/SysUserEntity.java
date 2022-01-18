package com.moyu.myadmin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.moyu.myadmin.config.PublicField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = true)
@ApiModel(value="用户基本信息")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class SysUserEntity extends PublicField implements Serializable {


    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value="用户ID")
    private String userId;

    /**
    * 用户名
    */
    @NotEmpty(message = "用户名不能为空")
    @ApiModelProperty(value="用户名", required = true)
    private String username;

    /**
    * 密码
    */
    @NotEmpty(message = "用户密码不能为空")
    @ApiModelProperty(value="密码", required = true)
    private String password;

    /**
    * 邮箱
    */
    @ApiModelProperty(value="邮箱")
    private String email;

    /**
    * 手机号码
    */
    @ApiModelProperty(value="手机号码")
    private String phoneNum;

    /**
    * 员工编码
    */
    @ApiModelProperty(value="员工编码")
    private String userCode;

    /**
    * 出生日期
    */
    @ApiModelProperty(value="出生日期")
    private Date birthday;

    /**
    * 身份证号
    */
    @ApiModelProperty(value="身份证号")
    private String idCard;

    /**
    * 民族
    */
    @ApiModelProperty(value="民族")
    private String nationality;

    /**
     * 启用
     */
    @ApiModelProperty(value="启用")
    private String state;

}