package com.moyu.myadmin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyu.myadmin.dao.entity.SysMenuEntity;
import com.moyu.myadmin.dao.mapper.SysMenuMapper;
import com.moyu.myadmin.model.convert.SysMenuConvert;
import com.moyu.myadmin.model.dto.SysMenuDTO;
import com.moyu.myadmin.model.vo.SysMenuVO;
import com.moyu.myadmin.service.SysMenuService;
import com.moyu.myadmin.utils.PageConvert;
import com.moyu.myadmin.utils.QueryData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuEntity> implements SysMenuService {

    @Override
    public Page<SysMenuVO> queryListPage(QueryData<SysMenuDTO> queryData) {
        Page<SysMenuEntity> page = new Page<>(queryData.getPageNum(), queryData.getPageSize());
        page = baseMapper.queryListPage(page, queryData.getData());
        List<SysMenuVO> voList = SysMenuConvert.INSTANCE.toVoList(page.getRecords());
        return PageConvert.convert(page, voList);
    }

    @Override
    public boolean save(SysMenuDTO dto) {
        SysMenuEntity entity = SysMenuConvert.INSTANCE.dtoToEntity(dto);
        return this.saveOrUpdate(entity);
    }
}