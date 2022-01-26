package com.moyu.myadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.moyu.myadmin.dao.entity.SysRoleEntity;
import com.moyu.myadmin.model.dto.SysRoleDTO;
import com.moyu.myadmin.model.vo.SysRoleVO;
import com.moyu.myadmin.utils.QueryData;

import java.util.List;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/18 22:00
 */

public interface SysRoleService extends IService<SysRoleEntity> {

    /**
     * 查询所有角色信息
     * @param entity 查询对象
     * @return 所有角色信息
     */
    List<SysRoleEntity> queryList(SysRoleEntity entity);

    /**
     * 分页重新
     * @param queryData 重新信息
     * @return 查询结果
     */
    Page<SysRoleVO> queryListPage(QueryData<SysRoleDTO> queryData);

    /**
     * 角色保存
     * @param dto 保存对象
     * @return 成功 失败
     */
    boolean saveRole(SysRoleDTO dto);
}
