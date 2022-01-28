package com.moyu.myadmin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import  com.moyu.myadmin.model.dto.SysUserRoleDTO;
import com.moyu.myadmin.model.vo.AssigningUserRoleVO;
import  com.moyu.myadmin.model.vo.SysUserRoleVO;
import  com.moyu.myadmin.service.SysUserRoleService;
import  com.moyu.myadmin.utils.QueryData;
import  com.moyu.myadmin.utils.ResultData;
import  com.moyu.myadmin.utils.ReturnCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

/**
 * 角色用户关联表
 *
 * @email jiaomingyu5778@gmail.com
 * @date 2022-01-28 11:33:14
 */
@Log4j2
@Api(tags = {"角色用户关联表接口"})
@RestController
@RequestMapping("/sysUserRole/")
public class SysUserRoleController {

    private final SysUserRoleService service;

    @Autowired
    public SysUserRoleController(SysUserRoleService service) {
        this.service = service;
    }

    @ApiOperation(value = "查询角色用户关联表信息根据用户ID")
    @PostMapping("queryUserRoleByUserId")
    public ResultData<AssigningUserRoleVO> queryUserRoleByUserId(@Valid @NotEmpty(message = "ID不能为空") @RequestBody String userId) {
        AssigningUserRoleVO vo = service.queryUserRoleByUserId(userId);
        return ResultData.success(vo);
    }

    @ApiOperation(value = "删除角色用户关联表信息根据用户ID")
    @PostMapping("delUserRoleByUserId")
    public ResultData<String> delUserRoleByUserId(@Valid @NotEmpty(message = "ID不能为空") @RequestBody String userId) {
        boolean delFlag = service.delUserRoleByUserId(userId);
        return delFlag ? ResultData.success(ReturnCode.RC200.getMessage()) : ResultData.error(ReturnCode.RC999.getMessage());
    }

    @ApiOperation(value = "分页查询角色用户关联表信息")
    @PostMapping("queryListPage")
    public ResultData<Page<SysUserRoleVO>> queryList(@RequestBody QueryData<SysUserRoleDTO> queryData) {
        log.info("角色用户关联表查询，查询信息：{}", queryData);
        Page<SysUserRoleVO> page = service.queryListPage(queryData);
        return ResultData.success(page);
    }

    @ApiOperation(value = "保存角色用户关联表信息")
    @PostMapping("saves")
    public ResultData<String> saves(@Valid @NotNull @Size(min = 1, message = "主键长度最小为1") @RequestBody List<SysUserRoleDTO> list) {
        log.info("角色用户关联表保存，批量保存信息：{}", list);
        boolean update = service.saves(list);
        return update ? ResultData.success(ReturnCode.RC200.getMessage()) : ResultData.error(ReturnCode.RC999.getMessage());
    }

    @ApiOperation(value = "保存角色用户关联表信息")
    @PostMapping("save")
    public ResultData<String> save(@ApiParam(value = "角色信息") @Valid @RequestBody SysUserRoleDTO dto) {
        log.info("角色用户关联表保存，保存信息：{}", dto);
        boolean update = service.save(dto);
        return update ? ResultData.success(ReturnCode.RC200.getMessage()) : ResultData.error(ReturnCode.RC999.getMessage());
    }

    @ApiOperation(value = "根据ID，批量删除角色用户关联表信息")
    @PostMapping("/deletes")
    public ResultData<String> deletes(@Valid @NotNull @Size(min = 1, message = "主键长度最小为1") @RequestBody List<String> userRoleIds) {
        boolean remove = service.removeBatchByIds(userRoleIds);
        return remove ? ResultData.success(ReturnCode.RC200.getMessage()) : ResultData.error(ReturnCode.RC999.getMessage());
    }

    @ApiOperation(value = "根据ID，删除角色用户关联表信息")
    @PostMapping("/delete")
    public ResultData<String> delete(@Valid @NotEmpty(message = "ID不能为空") @RequestBody String userRoleId) {
        boolean remove = service.removeById(userRoleId);
        return remove ? ResultData.success(ReturnCode.RC200.getMessage()) : ResultData.error(ReturnCode.RC999.getMessage());
    }



}
