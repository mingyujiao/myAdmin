package com.moyu.myadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.moyu.myadmin.dao.entity.SysOrgEntity;
import com.moyu.myadmin.model.dto.SysOrgDTO;
import com.moyu.myadmin.model.vo.SysOrgVO;

import java.util.List;

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
    List<SysOrgVO> queryListPage(SysOrgDTO queryData);

    /**
     * 角色保存
     * @param dto 保存对象
     * @return 成功 失败
     */
    boolean save(SysOrgDTO dto);

    /**
     * 查询组织机构表全部信息
     * @param queryData 查询数据信息
     * @return /
     */
    List<SysOrgVO> queryAllList(SysOrgDTO queryData);

    /**
     * 根据机构编码查询机构信息
     * @param dto 机构编码
     * @return 是否存在
     */
    boolean existOrgCode(SysOrgDTO dto);
}

