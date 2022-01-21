package com.moyu.myadmin.config;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.moyu.myadmin.dao.entity.SysUserEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/11 22:58
 */

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        SysUserEntity user = getSysUserEntity();
        log.info("===========开始赋值公共字段=============");
        this.strictInsertFill(metaObject, "rowVersion", Integer.class, 0);
        this.strictInsertFill(metaObject, "delFlag", Integer.class, 0);
        this.strictInsertFill(metaObject, "createBy", String.class, user.getUserId());
        this.strictInsertFill(metaObject, "createDate", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateBy", String.class, user.getUserId());
        this.strictInsertFill(metaObject, "updateDate", LocalDateTime.class, LocalDateTime.now());
        log.info("===========结束赋值公共字段=============");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        SysUserEntity user = getSysUserEntity();
        log.info("===========开始更新公共字段=============");
        this.strictInsertFill(metaObject, "updateBy", String.class, user.getUserId());
        this.strictInsertFill(metaObject, "updateDate", LocalDateTime.class, LocalDateTime.now());
        log.info("===========结束更新公共字段=============");
    }

    /**
     *
     * 获取用户信息
     * @return 当前登录用户信息
     */
    private SysUserEntity getSysUserEntity() {
        // TODO 有了角色以后，需要重构该方法
        SaSession session = StpUtil.getTokenSession();
        return (SysUserEntity) session.get("sysUser");
    }
}
