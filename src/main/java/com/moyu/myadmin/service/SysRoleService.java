package com.moyu.myadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.moyu.myadmin.entity.SysRoleEntity;

import java.util.List;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/18 22:00
 */

public interface SysRoleService extends IService<SysRoleEntity> {

    /**
     * 查询所有角色信息
     * @param entity 查询对象
     * @return 所有角色信息
     */
    List<SysRoleEntity> queryList(SysRoleEntity entity);
}
