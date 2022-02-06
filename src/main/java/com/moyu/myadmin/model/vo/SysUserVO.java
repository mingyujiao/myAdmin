package com.moyu.myadmin.model.vo;

import com.moyu.myadmin.utils.PublicField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/21 13:47
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserVO extends PublicField implements Serializable {

    private static final long serialVersionUID = -5154812135893921128L;

    @ApiModelProperty(value="用户ID")
    private String userId;

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    @ApiModelProperty(value="用户名", required = true)
    private String username;

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
    private LocalDate birthday;

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

    /**
     * 真实名称
     */
    @ApiModelProperty(value="真实名称")
    private String name;

    /**
     * 所属机构
     */
    @ApiModelProperty(value="所属机构")
    private String orgId;

}
