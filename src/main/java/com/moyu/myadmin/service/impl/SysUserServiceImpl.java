package com.moyu.myadmin.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moyu.myadmin.model.convert.SysUserConvert;
import com.moyu.myadmin.model.dto.SysUserDTO;
import com.moyu.myadmin.dao.entity.SysUserEntity;
import com.moyu.myadmin.dao.mapper.SysUserMapper;
import com.moyu.myadmin.model.vo.SysUserVO;
import com.moyu.myadmin.service.SysUserService;
import com.moyu.myadmin.utils.PageConvert;
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
    public boolean saveUser(SysUserDTO user) {
        if (Objects.isNull(user.getUserId())) {
            String md5BySalt = getMd5BySalt(user);
            user.setPassword(md5BySalt);
        }
        SysUserEntity entity = SysUserConvert.INSTANCE.dtoToEntity(user);
        return this.saveOrUpdate(entity);
    }

    @Override
    public boolean doLogin(SysUserDTO dto) {
        List<SysUserEntity> list = this.lambdaQuery().eq(SysUserEntity::getUsername, dto.getUsername()).list();
        if (CollectionUtils.isNotEmpty(list)) {
            SysUserEntity user = list.get(0);
            String md5BySalt = getMd5BySalt(dto);
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
     * @param dto 用户对象
     * @return 密码
     */
    private String getMd5BySalt(SysUserDTO dto) {
        return SaSecureUtil.md5BySalt(dto.getPassword(), dto.getUsername().substring(0, 3));
    }

    @Override
    public List<SysUserVO> queryList(SysUserDTO entity) {
        List<SysUserEntity> list = this.lambdaQuery().list();
        return SysUserConvert.INSTANCE.toVoList(list);
    }

    @Override
    public Page<SysUserVO> queryListPage(QueryData<SysUserDTO> queryData) {
        Page<SysUserEntity> page = new Page<>(queryData.getPageNum(), queryData.getPageSize());
        Page<SysUserEntity> entityPage = baseMapper.queryListPage(page, queryData.getData());
        List<SysUserVO> voList = SysUserConvert.INSTANCE.toVoList(entityPage.getRecords());
        return PageConvert.convert(page, voList);
    }

    @Override
    public SysUserVO getUserByToken() {
        SaSession session = StpUtil.getTokenSession();
        log.info("当前登录用户信息：{}", session.get(SysConstant.SESSION_KEY));
        return (SysUserVO) session.get(SysConstant.SESSION_KEY);
    }

    @Override
    public boolean resetPwd(SysUserDTO user) {
        String md5BySalt = getMd5BySalt(user);
        user.setPassword(md5BySalt);
        SysUserEntity entity = SysUserConvert.INSTANCE.dtoToEntity(user);
        return this.saveOrUpdate(entity);
    }
}
