package com.moyu.myadmin.model.convert;

import com.moyu.myadmin.dao.entity.SysRoleEntity;
import com.moyu.myadmin.model.dto.SysRoleDTO;
import com.moyu.myadmin.model.vo.SysRoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysRoleConvert {

    SysRoleConvert INSTANCE = Mappers.getMapper(SysRoleConvert.class);

    SysRoleVO toVo(SysRoleEntity source);

    List<SysRoleVO> toVoList(List<SysRoleEntity> listSource);

    SysRoleDTO toDTO(SysRoleEntity source);

    List<SysRoleDTO> toDtoList(List<SysRoleEntity> listSource);

    SysRoleEntity voToEntity(SysRoleVO source);

    List<SysRoleEntity> voEntityList(List<SysRoleVO> listSource);

    SysRoleEntity dtoToEntity(SysRoleDTO source);

    List<SysRoleEntity> dtoEntityList(List<SysRoleDTO> listSource);
}
