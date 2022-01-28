package com.moyu.myadmin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moyu.myadmin.model.dto.SysRoleDTO;
import com.moyu.myadmin.model.vo.SysRoleVO;
import com.moyu.myadmin.service.SysRoleService;
import com.moyu.myadmin.utils.QueryData;
import com.moyu.myadmin.utils.ResultData;
import com.moyu.myadmin.utils.ReturnCode;
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
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/18 22:02
 */

@Validated
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

    @ApiOperation(value = "分页查询用户信息")
    @PostMapping("queryListPage")
    public ResultData<Page<SysRoleVO>> queryList(@RequestBody QueryData<SysRoleDTO> queryData) {
        Page<SysRoleVO> page = sysRoleService.queryListPage(queryData);
        return ResultData.success(page);
    }

    @ApiOperation(value = "保存角色信息")
    @PostMapping("save")
    public ResultData<String> save(@ApiParam(value = "角色信息") @Valid @RequestBody SysRoleDTO dto) {
        boolean update = sysRoleService.saveRole(dto);
        return update ? ResultData.success(ReturnCode.RC200.getMessage()) : ResultData.error(ReturnCode.RC999.getMessage());
    }


    @ApiOperation(value = "根据ID，批量删除角色信息")
    @PostMapping("/deletes")
    public ResultData<String> deletes(@Valid @NotNull @Size(min = 1, message = "主键长度最小为1") @RequestBody List<String> roleIds) {
        boolean remove = sysRoleService.removeBatchByIds(roleIds);
        return remove ? ResultData.success(ReturnCode.RC200.getMessage()) : ResultData.error(ReturnCode.RC999.getMessage());
    }

    @ApiOperation(value = "根据ID，删除用户信息")
    @PostMapping("/delete")
    public ResultData<String> delete(@Valid @NotEmpty(message = "ID不能为空") @RequestBody String roleId) {
        boolean remove = sysRoleService.removeById(roleId);
        return remove ? ResultData.success(ReturnCode.RC200.getMessage()) : ResultData.error(ReturnCode.RC999.getMessage());
    }
}

















