package com.moyu.myadmin.model.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/28 14:33
 */
@Data
@Builder
public class AssigningUserRoleVO implements Serializable {

    private static final long serialVersionUID = 8179759456033791575L;

    /**
     * 角色
     */
    private List<SysRoleVO> roles;

    /**
     * 用户角色
     */
    private List<SysUserRoleVO> userRoles;
}
