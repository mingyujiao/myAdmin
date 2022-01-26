package com.moyu.myadmin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyu.myadmin.dao.entity.SysRoleEntity;
import com.moyu.myadmin.dao.mapper.SysRoleMapper;
import com.moyu.myadmin.model.convert.SysRoleConvert;
import com.moyu.myadmin.model.dto.SysRoleDTO;
import com.moyu.myadmin.model.vo.SysRoleVO;
import com.moyu.myadmin.service.SysRoleService;
import com.moyu.myadmin.utils.PageConvert;
import com.moyu.myadmin.utils.QueryData;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/18 22:01
 */

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRoleEntity> implements SysRoleService {

    @Override
    public List<SysRoleEntity> queryList(SysRoleEntity entity) {
        return this.lambdaQuery().list();
    }

    @Override
    public Page<SysRoleVO> queryListPage(QueryData<SysRoleDTO> queryData) {
        Page<SysRoleEntity> page = new Page<>(queryData.getPageNum(), queryData.getPageSize());
        page = baseMapper.queryListPage(page, queryData.getData());
        List<SysRoleVO> voList = SysRoleConvert.INSTANCE.toVoList(page.getRecords());
        return PageConvert.convert(page, voList);
    }

    @Override
    public boolean saveRole(SysRoleDTO dto) {
        SysRoleEntity entity = SysRoleConvert.INSTANCE.dtoToEntity(dto);
        return this.saveOrUpdate(entity);
    }
}
