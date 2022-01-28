package com.moyu.myadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.moyu.myadmin.dao.entity.SysUserRoleEntity;
import com.moyu.myadmin.model.dto.SysUserRoleDTO;
import com.moyu.myadmin.model.vo.AssigningUserRoleVO;
import com.moyu.myadmin.model.vo.SysUserRoleVO;
import com.moyu.myadmin.utils.QueryData;

import java.util.List;

/**
 * 角色用户关联表
 *
 * @author jiaomingyu
 * @email jiaomingyu5778@gmail.com
 * @date 2022-01-28 11:33:14
 */
public interface SysUserRoleService extends IService<SysUserRoleEntity> {

    /**
     * 分页重新
     * @param queryData 查询参数
     * @return 查询结果
     */
    Page<SysUserRoleVO> queryListPage(QueryData<SysUserRoleDTO> queryData);

    /**
     * 角色保存
     * @param dto 保存对象
     * @return 成功 失败
     */
    boolean save(SysUserRoleDTO dto);

    /**
     * 返回用户授权角色
     * @param userId 用户ID
     * @return 角色信息
     */
    AssigningUserRoleVO queryUserRoleByUserId(String userId);

    /**
     * 删除角色用户关联表信息根据用户ID
     * @param userId 用户ID
     */
    boolean delUserRoleByUserId(String userId);

    /**
     * 批量保存
     * @param list 待入库信息
     * @return 成功失败
     */
    boolean saves(List<SysUserRoleDTO> list);
}

