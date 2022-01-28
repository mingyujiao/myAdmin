package com.moyu.myadmin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import  com.moyu.myadmin.model.dto.SysOrgDTO;
import  com.moyu.myadmin.model.vo.SysOrgVO;
import  com.moyu.myadmin.service.SysOrgService;
import  com.moyu.myadmin.utils.QueryData;
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
 * 组织机构表
 *
 * @email jiaomingyu5778@gmail.com
 * @date 2022-01-28 20:23:03
 */
@Log4j2
@Api(tags = {"组织机构表接口"})
@RestController
@RequestMapping("/sysOrg/")
public class SysOrgController {

    private final SysOrgService service;

    @Autowired
    public SysOrgController(SysOrgService service) {
        this.service = service;
    }

    @ApiOperation(value = "分页查询组织机构表信息")
    @PostMapping("queryListPage")
    public ResultData<Page<SysOrgVO>> queryList(@RequestBody QueryData<SysOrgDTO> queryData) {
        log.info("组织机构表查询，查询信息：{}", queryData);
        Page<SysOrgVO> page = service.queryListPage(queryData);
        return ResultData.success(page);
    }

    @ApiOperation(value = "保存组织机构表信息")
    @PostMapping("save")
    public ResultData<String> save(@ApiParam(value = "角色信息") @Valid @RequestBody SysOrgDTO dto) {
        log.info("组织机构表保存，保存信息：{}", dto);
        boolean update = service.save(dto);
        return update ? ResultData.success(ReturnCode.RC200.getMessage()) : ResultData.error(ReturnCode.RC999.getMessage());
    }

    @ApiOperation(value = "根据ID，批量删除组织机构表信息")
    @PostMapping("/deletes")
    public ResultData<String> deletes(@Valid @NotNull @Size(min = 1, message = "主键长度最小为1") @RequestBody List<String> orgIds) {
        boolean remove = service.removeBatchByIds(orgIds);
        return remove ? ResultData.success(ReturnCode.RC200.getMessage()) : ResultData.error(ReturnCode.RC999.getMessage());
    }

    @ApiOperation(value = "根据ID，删除组织机构表信息")
    @PostMapping("/delete")
    public ResultData<String> delete(@Valid @NotEmpty(message = "ID不能为空") @RequestBody String orgId) {
        boolean remove = service.removeById(orgId);
        return remove ? ResultData.success(ReturnCode.RC200.getMessage()) : ResultData.error(ReturnCode.RC999.getMessage());
    }



}
