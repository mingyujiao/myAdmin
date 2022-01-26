package com.moyu.myadmin.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moyu.myadmin.dao.entity.SysRoleEntity;
import com.moyu.myadmin.model.dto.SysRoleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRoleEntity> {

    /**
     * 分页查询角色信息
     * @param page 分页信息
     * @param data 查询参数
     * @return 结果
     */
    Page<SysRoleEntity> queryListPage(Page<SysRoleEntity> page, @Param("dto") SysRoleDTO data);
}