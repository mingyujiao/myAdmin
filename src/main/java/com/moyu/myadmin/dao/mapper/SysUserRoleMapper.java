package com.moyu.myadmin.dao.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moyu.myadmin.dao.entity.SysUserRoleEntity;
import com.moyu.myadmin.model.dto.SysUserRoleDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色用户关联表
 * 
 * @author jiaomingyu
 * @email jiaomingyu5778@gmail.com
 * @date 2022-01-28 11:33:14
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRoleEntity> {

    /**
     * 分页查询
     * @param page 分页参数
     * @param data 查询参数
     * @return 结果集
     */
    Page<SysUserRoleEntity> queryListPage(Page<SysUserRoleEntity> page, SysUserRoleDTO data);
}
