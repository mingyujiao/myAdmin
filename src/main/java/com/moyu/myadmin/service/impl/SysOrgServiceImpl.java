package com.moyu.myadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyu.myadmin.dao.entity.SysOrgEntity;
import com.moyu.myadmin.dao.mapper.SysOrgMapper;
import com.moyu.myadmin.model.convert.SysOrgConvert;
import com.moyu.myadmin.model.dto.SysOrgDTO;
import com.moyu.myadmin.model.vo.SysOrgVO;
import com.moyu.myadmin.service.SysOrgService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SysOrgServiceImpl extends ServiceImpl<SysOrgMapper, SysOrgEntity> implements SysOrgService {

    @Override
    public List<SysOrgVO> queryListPage(SysOrgDTO queryData) {
        List<SysOrgEntity> list = baseMapper.queryListPage(queryData);
        return SysOrgConvert.INSTANCE.toVoList(list);
    }

    @Override
    public boolean save(SysOrgDTO dto) {
        SysOrgEntity entity = SysOrgConvert.INSTANCE.dtoToEntity(dto);
        return this.saveOrUpdate(entity);
    }

    @Override
    public List<SysOrgVO> queryAllList(SysOrgDTO queryData) {
        QueryWrapper<SysOrgEntity> query = new QueryWrapper<>();
        query.lambda().ne(Objects.nonNull(queryData.getOrgId()), SysOrgEntity::getOrgId, queryData.getOrgId());
        List<SysOrgEntity> list = baseMapper.selectList(query);
        return SysOrgConvert.INSTANCE.toVoList(list);
    }
}