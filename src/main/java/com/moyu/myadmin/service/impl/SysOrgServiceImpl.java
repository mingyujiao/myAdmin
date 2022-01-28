package com.moyu.myadmin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyu.myadmin.dao.entity.SysOrgEntity;
import com.moyu.myadmin.dao.mapper.SysOrgMapper;
import com.moyu.myadmin.model.convert.SysOrgConvert;
import com.moyu.myadmin.model.dto.SysOrgDTO;
import com.moyu.myadmin.model.vo.SysOrgVO;
import com.moyu.myadmin.service.SysOrgService;
import com.moyu.myadmin.utils.PageConvert;
import com.moyu.myadmin.utils.QueryData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysOrgServiceImpl extends ServiceImpl<SysOrgMapper, SysOrgEntity> implements SysOrgService {

    @Override
    public Page<SysOrgVO> queryListPage(QueryData<SysOrgDTO> queryData) {
        Page<SysOrgEntity> page = new Page<>(queryData.getPageNum(), queryData.getPageSize());
        page = baseMapper.queryListPage(page, queryData.getData());
        List<SysOrgVO> voList = SysOrgConvert.INSTANCE.toVoList(page.getRecords());
        return PageConvert.convert(page, voList);
    }

    @Override
    public boolean save(SysOrgDTO dto) {
        SysOrgEntity entity = SysOrgConvert.INSTANCE.dtoToEntity(dto);
        return this.saveOrUpdate(entity);
    }
}