package com.moyu.myadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyu.myadmin.dao.entity.SysUserRoleEntity;
import com.moyu.myadmin.dao.mapper.SysUserRoleMapper;
import com.moyu.myadmin.model.convert.SysUserRoleConvert;
import com.moyu.myadmin.model.dto.SysUserRoleDTO;
import com.moyu.myadmin.model.vo.AssigningUserRoleVO;
import com.moyu.myadmin.model.vo.SysRoleVO;
import com.moyu.myadmin.model.vo.SysUserRoleVO;
import com.moyu.myadmin.service.SysRoleService;
import com.moyu.myadmin.service.SysUserRoleService;
import com.moyu.myadmin.utils.PageConvert;
import com.moyu.myadmin.utils.QueryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRoleEntity> implements SysUserRoleService {

    private final SysRoleService sysRoleService;

    @Autowired
    public SysUserRoleServiceImpl(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @Override
    public Page<SysUserRoleVO> queryListPage(QueryData<SysUserRoleDTO> queryData) {
        Page<SysUserRoleEntity> page = new Page<>(queryData.getPageNum(), queryData.getPageSize());
        page = baseMapper.queryListPage(page, queryData.getData());
        List<SysUserRoleVO> voList = SysUserRoleConvert.INSTANCE.toVoList(page.getRecords());
        return PageConvert.convert(page, voList);
    }

    @Override
    public boolean save(SysUserRoleDTO dto) {
        SysUserRoleEntity entity = SysUserRoleConvert.INSTANCE.dtoToEntity(dto);
        return this.saveOrUpdate(entity);
    }

    @Override
    public AssigningUserRoleVO queryUserRoleByUserId(String userId) {
        // 查询用户已经授权的角色信息
        List<SysUserRoleEntity> userRoleEntities = getSysUserRoleByUserId(userId);
        List<SysUserRoleVO> userRoleVOS = SysUserRoleConvert.INSTANCE.toVoList(userRoleEntities);
        // 查询系统所有的角色信息
        List<SysRoleVO> sysRoleVOS = sysRoleService.queryList();
        return AssigningUserRoleVO.builder().userRoles(userRoleVOS).roles(sysRoleVOS).build();
    }

    @Override
    public boolean delUserRoleByUserId(String userId) {
        QueryWrapper<SysUserRoleEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUserRoleEntity::getUserId, userId);
        return this.remove(queryWrapper);
    }

    @Override
    public boolean saves(List<SysUserRoleDTO> list) {
        // 删除老数据
        this.delUserRoleByUserId(list.get(0).getUserId());
        // 入库
        List<SysUserRoleEntity> userRoleEntities = SysUserRoleConvert.INSTANCE.dtoEntityList(list);
        return this.saveBatch(userRoleEntities);
    }

    /**
     * 根据用户ID 查询授权信息
     * @param userId 用户ID
     * @return 集合
     */
    private List<SysUserRoleEntity> getSysUserRoleByUserId(String userId) {
        return this.lambdaQuery().eq(SysUserRoleEntity::getUserId, userId).list();
    }
}