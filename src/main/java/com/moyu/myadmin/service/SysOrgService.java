package com.moyu.myadmin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.moyu.myadmin.dao.entity.SysOrgEntity;
import com.moyu.myadmin.model.dto.SysOrgDTO;
import com.moyu.myadmin.model.vo.SysOrgVO;
import com.moyu.myadmin.utils.QueryData;

/**
 * 组织机构表
 *
 * @email jiaomingyu5778@gmail.com
 * @date 2022-01-28 20:23:03
 */
public interface SysOrgService extends IService<SysOrgEntity> {

    /**
     * 分页重新
     * @param queryData 查询参数
     * @return 查询结果
     */
    Page<SysOrgVO> queryListPage(QueryData<SysOrgDTO> queryData);

    /**
     * 角色保存
     * @param dto 保存对象
     * @return 成功 失败
     */
    boolean save(SysOrgDTO dto);
}

