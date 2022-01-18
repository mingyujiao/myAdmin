package com.moyu.myadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyu.myadmin.entity.SysRoleEntity;
import com.moyu.myadmin.mapper.SysRoleMapper;
import com.moyu.myadmin.service.SysRoleService;
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
}
