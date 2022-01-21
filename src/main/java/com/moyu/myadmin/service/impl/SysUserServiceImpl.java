package com.moyu.myadmin.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyu.myadmin.dto.SysUserDTO;
import com.moyu.myadmin.entity.SysUserEntity;
import com.moyu.myadmin.mapper.SysUserMapper;
import com.moyu.myadmin.service.SysUserService;
import com.moyu.myadmin.utils.QueryData;
import com.moyu.myadmin.utils.SysConstant;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


/**
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/14 22:36
 */

@Log4j2
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

    @Override
    public boolean saveUser(SysUserEntity user) {
        if (Objects.nonNull(user)) {
            String md5BySalt = getMd5BySalt(user);
            user.setPassword(md5BySalt);
        }
        return this.save(user);
    }

    @Override
    public boolean doLogin(SysUserEntity entity) {
        List<SysUserEntity> list = this.lambdaQuery().eq(SysUserEntity::getUsername, entity.getUsername()).list();
        if (CollectionUtils.isNotEmpty(list)) {
            SysUserEntity user = list.get(0);
            String md5BySalt = getMd5BySalt(entity);
            if (StringUtils.equals(user.getPassword(), md5BySalt)) {
                StpUtil.login(user.getUserId());
                SaSession session = StpUtil.getTokenSession();
                session.set(SysConstant.SESSION_KEY, user);
                return true;
            }
        }
        return false;
    }

    /**
     * 获取 md5 + 盐 后的密码
     * @param entity 用户对象
     * @return 密码
     */
    private String getMd5BySalt(SysUserEntity entity) {
        return SaSecureUtil.md5BySalt(entity.getPassword(), entity.getUsername().substring(0, 3));
    }

    @Override
    public List<SysUserEntity> queryList(SysUserEntity entity) {
        return this.lambdaQuery().list();
    }

    @Override
    public Page<SysUserEntity> queryListPage(QueryData<SysUserDTO> queryData) {
        Page<SysUserDTO> page = new Page<>(queryData.getPageNum(), queryData.getPageSize());
        return baseMapper.queryListPage(page, queryData.getData());
    }

    @Override
    public SysUserEntity getUserByToken() {
        SaSession session = StpUtil.getTokenSession();

        log.info("当前登录用户信息：{}", session.get(SysConstant.SESSION_KEY));
        return (SysUserEntity) session.get(SysConstant.SESSION_KEY);
    }
}
