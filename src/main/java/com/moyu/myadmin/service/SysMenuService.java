package com.moyu.myadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.moyu.myadmin.dao.entity.SysMenuEntity;
import com.moyu.myadmin.model.dto.SysMenuDTO;
import com.moyu.myadmin.model.vo.SysMenuVO;
import com.moyu.myadmin.utils.QueryData;

/**
 * 菜单管理
 *
 * @email jiaomingyu5778@gmail.com
 * @date 2022-02-06 18:17:03
 */
public interface SysMenuService extends IService<SysMenuEntity> {

    /**
     * 分页重新
     * @param queryData 查询参数
     * @return 查询结果
     */
    Page<SysMenuVO> queryListPage(QueryData<SysMenuDTO> queryData);

    /**
     * 角色保存
     * @param dto 保存对象
     * @return 成功 失败
     */
    boolean save(SysMenuDTO dto);
}

