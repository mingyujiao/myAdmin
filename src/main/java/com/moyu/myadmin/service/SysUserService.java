package com.moyu.myadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.moyu.myadmin.entity.SysUserEntity;

import java.util.List;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/14 22:35
 */

public interface SysUserService extends IService<SysUserEntity> {

    /**
     * 添加用户
     * @param user 用户信息
     * @return 数据库 对象
     */
    boolean saveUser(SysUserEntity user);

    /**
     * 用户登录
     * @param username 用户名称
     * @param password 密码
     * @return 成功失败
     */
    boolean doLogin(String username, String password);


    /**
     * 查询全部用户信息
     * @param entity 查询对象
     * @return 用户集合
     */
    List<SysUserEntity> queryList(SysUserEntity entity);
}
