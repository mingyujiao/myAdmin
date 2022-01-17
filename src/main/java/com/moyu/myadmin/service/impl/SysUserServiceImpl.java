package com.moyu.myadmin.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyu.myadmin.entity.SysUserEntity;
import com.moyu.myadmin.mapper.SysUserMapper;
import com.moyu.myadmin.service.SysUserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


/**
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/14 22:36
 */

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

    @Override
    public boolean saveUser(SysUserEntity user) {
        if (Objects.nonNull(user)) {
            String passWord = Objects.isNull(user.getPassword()) ? "123456" : user.getPassword();
            String md5BySalt = SaSecureUtil.md5BySalt(passWord, user.getUserName().substring(0, 6));
            user.setPassword(md5BySalt);
        }
        return this.save(user);
    }

    @Override
    public boolean doLogin(SysUserEntity entity) {
        List<SysUserEntity> list = this.lambdaQuery().eq(SysUserEntity::getUserName, entity.getUserName()).list();
        if (CollectionUtils.isNotEmpty(list)) {
            SysUserEntity user = list.get(0);
            String md5BySalt = SaSecureUtil.md5BySalt(entity.getPassword(), user.getUserName().substring(0, 6));
            if (StringUtils.equals(user.getPassword(), md5BySalt)) {
                StpUtil.login(user.getUserId());
                return true;
            }
        }
        return false;
    }

    @Override
    public List<SysUserEntity> queryList(SysUserEntity entity) {
        return this.lambdaQuery().list();
    }
}
