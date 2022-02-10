package com.moyu.myadmin.dao.mapper;

import com.moyu.myadmin.dao.entity.SysMenuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moyu.myadmin.model.dto.SysMenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单管理
 *
 * @email jiaomingyu5778@gmail.com
 * @date 2022-02-06 18:17:03
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {

    /**
     * 分页查询
     * @param data 查询参数
     * @return 结果集
     */
    List<SysMenuEntity> queryListPage(SysMenuDTO data);
}
