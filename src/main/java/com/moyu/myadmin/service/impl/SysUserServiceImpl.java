package com.moyu.myadmin.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyu.myadmin.entity.SysUserEntity;
import com.moyu.myadmin.mapper.SysUserMapper;
import com.moyu.myadmin.service.SysUserService;
import org.springframework.stereotype.Service;

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
    public boolean doLogin(String username, String password) {
        QueryWrapper<SysUserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        SysUserEntity user = baseMapper.selectOne(wrapper);
        String md5BySalt = SaSecureUtil.md5BySalt(password, user.getUserName().substring(0, 6));
        return StringUtils.equals(user.getPassword(), md5BySalt);
    }
}
