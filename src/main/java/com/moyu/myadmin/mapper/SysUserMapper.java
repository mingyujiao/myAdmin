package com.moyu.myadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moyu.myadmin.dto.SysUserDTO;
import com.moyu.myadmin.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

    /**
     * 分页查询用户信息
     * @param dto 查询参数
     * @return 查询结果
     */
    Page<SysUserEntity> queryListPage(Page<SysUserDTO> dto);
}