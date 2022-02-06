package com.moyu.myadmin.model.convert;

import com.moyu.myadmin.dao.entity.SysMenuEntity;
import com.moyu.myadmin.model.dto.SysMenuDTO;
import com.moyu.myadmin.model.vo.SysMenuVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 菜单管理
 * 
 * @email jiaomingyu5778@gmail.com
 * @date 2022-02-06 18:17:03
 */
@Mapper
public interface SysMenuConvert {

	SysMenuConvert INSTANCE = Mappers.getMapper(SysMenuConvert.class);

	SysMenuVO toVO(SysMenuEntity source);

	List<SysMenuVO> toVoList(List<SysMenuEntity> listSource);

	SysMenuDTO toDTO(SysMenuEntity source);

	List<SysMenuDTO> toDtoList(List<SysMenuEntity> listSource);

	SysMenuEntity toToEntity(SysMenuVO source);

	List<SysMenuEntity> voEntityList(List<SysMenuVO> listSource);

	SysMenuEntity dtoToEntity(SysMenuDTO source);

	List<SysMenuEntity> dtoEntityList(List<SysMenuDTO> listSource);

}
