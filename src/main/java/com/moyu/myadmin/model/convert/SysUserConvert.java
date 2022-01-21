package com.moyu.myadmin.model.convert;

import com.moyu.myadmin.dao.entity.SysUserEntity;
import com.moyu.myadmin.model.dto.SysUserDTO;
import com.moyu.myadmin.model.vo.SysUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysUserConvert {

    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    SysUserVO toVo(SysUserEntity source);

    List<SysUserVO> toVoList(List<SysUserEntity> listSource);

    SysUserDTO toDTO(SysUserEntity source);

    List<SysUserDTO> toDtoList(List<SysUserEntity> listSource);

    SysUserEntity voToEntity(SysUserVO source);

    List<SysUserEntity> voEntityList(List<SysUserVO> listSource);

    SysUserEntity dtoToEntity(SysUserDTO source);

    List<SysUserEntity> dtoEntityList(List<SysUserDTO> listSource);
}
