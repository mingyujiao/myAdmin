package com.moyu.myadmin.model.convert;

import com.moyu.myadmin.dao.entity.SysUserRoleEntity;
import com.moyu.myadmin.model.dto.SysUserRoleDTO;
import com.moyu.myadmin.model.vo.SysUserRoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 角色用户关联表
 * 
 * @author jiaomingyu
 * @email jiaomingyu5778@gmail.com
 * @date 2022-01-28 11:33:14
 */
@Mapper
public interface SysUserRoleConvert {

	SysUserRoleConvert INSTANCE = Mappers.getMapper(SysUserRoleConvert.class);

	SysUserRoleVO toVO(SysUserRoleEntity source);

	List<SysUserRoleVO> toVoList(List<SysUserRoleEntity> listSource);

	SysUserRoleDTO toDTO(SysUserRoleEntity source);

	List<SysUserRoleDTO> toDtoList(List<SysUserRoleEntity> listSource);

	SysUserRoleEntity toToEntity(SysUserRoleVO source);

	List<SysUserRoleEntity> voEntityList(List<SysUserRoleVO> listSource);

	SysUserRoleEntity dtoToEntity(SysUserRoleDTO source);

	List<SysUserRoleEntity> dtoEntityList(List<SysUserRoleDTO> listSource);

}
