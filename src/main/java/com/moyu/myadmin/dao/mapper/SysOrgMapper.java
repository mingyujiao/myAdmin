package com.moyu.myadmin.dao.mapper;

import com.moyu.myadmin.dao.entity.SysOrgEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moyu.myadmin.model.dto.SysOrgDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 组织机构表
 *
 * @email jiaomingyu5778@gmail.com
 * @date 2022-01-28 20:23:03
 */
@Mapper
public interface SysOrgMapper extends BaseMapper<SysOrgEntity> {

    /**
     * 分页查询
     * @param data 查询参数
     * @return 结果集
     */
    List<SysOrgEntity> queryListPage(SysOrgDTO data);
}
