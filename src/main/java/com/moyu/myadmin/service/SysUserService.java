package com.moyu.myadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.moyu.myadmin.dto.SysUserDTO;
import com.moyu.myadmin.entity.SysUserEntity;
import com.moyu.myadmin.utils.QueryData;

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
     * @param entity 用户登录信息
     * @return 成功失败
     */
    boolean doLogin(SysUserEntity entity);


    /**
     * 查询全部用户信息
     * @param entity 查询对象
     * @return 用户集合
     */
    List<SysUserEntity> queryList(SysUserEntity entity);

    /**
     * 分页查询用户信息
     * @param queryData 查询对象
     * @return 分页信息
     */
    Page<SysUserEntity> queryListPage(QueryData<SysUserDTO> queryData);
}
