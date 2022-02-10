package com.moyu.myadmin.controller;

import  com.moyu.myadmin.model.dto.SysMenuDTO;
import  com.moyu.myadmin.model.vo.SysMenuVO;
import  com.moyu.myadmin.service.SysMenuService;
import  com.moyu.myadmin.utils.ResultData;
import  com.moyu.myadmin.utils.ReturnCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

/**
 * 菜单管理
 *
 * @email jiaomingyu5778@gmail.com
 * @date 2022-02-06 18:17:03
 */
@Log4j2
@Validated
@Api(tags = {"菜单管理接口"})
@RestController
@RequestMapping("/sysMenu/")
public class SysMenuController {

    private final SysMenuService service;

    @Autowired
    public SysMenuController(SysMenuService service) {
        this.service = service;
    }

    @ApiOperation(value = "分页查询菜单管理信息")
    @PostMapping("queryListPage")
    public ResultData<List<SysMenuVO>> queryList(@RequestBody SysMenuDTO queryData) {
        log.info("菜单管理查询，查询信息：{}", queryData);
        List<SysMenuVO> page = service.queryListPage(queryData);
        return ResultData.success(page);
    }

    @ApiOperation(value = "查询菜单管理信息")
    @PostMapping("queryAllList")
    public ResultData<List<SysMenuVO>> queryAllList(@RequestBody SysMenuDTO queryData) {
        log.info("查询菜单管理信息，查询信息：{}", queryData);
        List<SysMenuVO> voList = service.queryAllList(queryData);
        return ResultData.success(voList);
    }

    @ApiOperation(value = "保存菜单管理信息")
    @PostMapping("save")
    public ResultData<String> save(@ApiParam(value = "角色信息") @Valid @RequestBody SysMenuDTO dto) {
        log.info("菜单管理保存，保存信息：{}", dto);
        boolean update = service.save(dto);
        return update ? ResultData.success(ReturnCode.RC200.getMessage()) : ResultData.error(ReturnCode.RC999.getMessage());
    }

    @ApiOperation(value = "根据ID，批量删除菜单管理信息")
    @PostMapping("/deletes")
    public ResultData<String> deletes(@Valid @NotNull @Size(min = 1, message = "主键长度最小为1") @RequestBody List<String> orgIds) {
        boolean remove = service.removeBatchByIds(orgIds);
        return remove ? ResultData.success(ReturnCode.RC200.getMessage()) : ResultData.error(ReturnCode.RC999.getMessage());
    }

    @ApiOperation(value = "根据ID，删除菜单管理信息")
    @PostMapping("/delete")
    public ResultData<String> delete(@Valid @NotEmpty(message = "ID不能为空") @RequestBody String orgId) {
        boolean remove = service.removeById(orgId);
        return remove ? ResultData.success(ReturnCode.RC200.getMessage()) : ResultData.error(ReturnCode.RC999.getMessage());
    }



}
