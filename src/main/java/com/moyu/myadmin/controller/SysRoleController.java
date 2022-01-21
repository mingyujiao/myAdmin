package com.moyu.myadmin.controller;

import com.moyu.myadmin.dao.entity.SysRoleEntity;
import com.moyu.myadmin.service.SysRoleService;
import com.moyu.myadmin.utils.ResultData;
import com.moyu.myadmin.utils.ReturnCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/18 22:02
 */

@Log4j2
@Api(tags = "用户角色")
@RestController
@RequestMapping("/sysRole/")
public class SysRoleController {

    private final SysRoleService sysRoleService;

    @Autowired
    public SysRoleController(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @ApiOperation(value = "查询所有角色信息")
    @PostMapping("queryList")
    public ResultData<List<SysRoleEntity>> queryList(SysRoleEntity entity) {
        List<SysRoleEntity> roleEntities = sysRoleService.queryList(entity);
        return ResultData.success(roleEntities);
    }

    @ApiOperation(value = "保存角色信息")
    @PostMapping("save")
    public ResultData<String> save(SysRoleEntity entity) {
        boolean update = sysRoleService.saveOrUpdate(entity);
        return update ? ResultData.success(ReturnCode.RC200.getMessage()) : ResultData.error(ReturnCode.RC999.getMessage());
    }
}

















