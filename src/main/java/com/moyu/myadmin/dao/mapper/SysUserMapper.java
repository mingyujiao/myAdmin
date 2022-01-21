package com.moyu.myadmin.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moyu.myadmin.model.dto.SysUserDTO;
import com.moyu.myadmin.dao.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

    /**
     * 分页查询用户信息
     *
     * @param page 分页信息
     * @param dto  查询参数
     * @return 查询结果
     */
    Page<SysUserEntity> queryListPage(Page<SysUserEntity> page, @Param("dto") SysUserDTO dto);
}