package com.moyu.myadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyu.myadmin.dao.entity.SysMenuEntity;
import com.moyu.myadmin.dao.mapper.SysMenuMapper;
import com.moyu.myadmin.model.convert.SysMenuConvert;
import com.moyu.myadmin.model.dto.SysMenuDTO;
import com.moyu.myadmin.model.vo.SysMenuVO;
import com.moyu.myadmin.service.SysMenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuEntity> implements SysMenuService {

    @Override
    public List<SysMenuVO> queryListPage(SysMenuDTO queryData) {
        List<SysMenuEntity> list = baseMapper.queryListPage(queryData);
        return SysMenuConvert.INSTANCE.toVoList(list);
    }

    @Override
    public boolean save(SysMenuDTO dto) {
        SysMenuEntity entity = SysMenuConvert.INSTANCE.dtoToEntity(dto);
        return this.saveOrUpdate(entity);
    }

    @Override
    public List<SysMenuVO> queryAllList(SysMenuDTO queryData) {
        QueryWrapper<SysMenuEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().ne(Objects.nonNull(queryData.getMenuId()), SysMenuEntity::getMenuId, queryData.getMenuId());
        List<SysMenuEntity> entities = baseMapper.selectList(wrapper);
        return SysMenuConvert.INSTANCE.toVoList(entities);
    }
}