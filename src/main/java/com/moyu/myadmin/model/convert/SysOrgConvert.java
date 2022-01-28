package com.moyu.myadmin.model.convert;

import com.moyu.myadmin.dao.entity.SysOrgEntity;
import com.moyu.myadmin.model.dto.SysOrgDTO;
import com.moyu.myadmin.model.vo.SysOrgVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 组织机构表
 * 
 * @email jiaomingyu5778@gmail.com
 * @date 2022-01-28 20:23:03
 */
@Mapper
public interface SysOrgConvert {

	SysOrgConvert INSTANCE = Mappers.getMapper(SysOrgConvert.class);

	SysOrgVO toVO(SysOrgEntity source);

	List<SysOrgVO> toVoList(List<SysOrgEntity> listSource);

	SysOrgDTO toDTO(SysOrgEntity source);

	List<SysOrgDTO> toDtoList(List<SysOrgEntity> listSource);

	SysOrgEntity toToEntity(SysOrgVO source);

	List<SysOrgEntity> voEntityList(List<SysOrgVO> listSource);

	SysOrgEntity dtoToEntity(SysOrgDTO source);

	List<SysOrgEntity> dtoEntityList(List<SysOrgDTO> listSource);

}
