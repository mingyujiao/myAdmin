package com.moyu.myadmin.controller;


import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moyu.myadmin.model.dto.SysUserDTO;
import com.moyu.myadmin.model.vo.SysUserVO;
import com.moyu.myadmin.service.SysUserService;
import com.moyu.myadmin.utils.QueryData;
import com.moyu.myadmin.utils.ResultData;
import com.moyu.myadmin.utils.ReturnCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Validated
@Log4j2
@Api(tags = "用户管理")
@RestController
@RequestMapping("/sysUser/")
public class SysUserController {

    private final SysUserService sysUserService;

    @Autowired
    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @ApiOperation(value = "分页重新用户信息")
    @PostMapping("queryListPage")
    public ResultData<Page<SysUserVO>> queryListPage(@RequestBody QueryData<SysUserDTO> queryData) {
        Page<SysUserVO> page = sysUserService.queryListPage(queryData);
        return ResultData.success(page);
    }

    @ApiOperation(value = "获取用户信息")
    @PostMapping("getUserByToken")
    public ResultData<SysUserVO> getUserByToken() {
        return ResultData.success(sysUserService.getUserByToken());
    }

    @ApiOperation(value = "查询所有用户信息")
    @PostMapping("queryList")
    public ResultData<List<SysUserVO>> queryList(SysUserDTO entity) {
        List<SysUserVO> userEntities = sysUserService.queryList(entity);
        return ResultData.success(userEntities);
    }

    @ApiImplicitParam(name = "entity", value = "登录信息", required = true)
    @ApiOperation(value = "用户登录")
    @PostMapping("doLogin")
    public ResultData<Object> doLogin(@RequestBody SysUserDTO entity) {
        boolean loginFlag = sysUserService.doLogin(entity);
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return loginFlag ? ResultData.success(tokenInfo) : ResultData.error(ReturnCode.RC999.getMessage());
    }

    @ApiOperation(value = "添加用户")
    @PostMapping("save")
    public ResultData<String> save(@ApiParam(value = "用户信息") @Valid @RequestBody SysUserDTO user) {
        boolean save = sysUserService.saveUser(user);
        return save ? ResultData.success(ReturnCode.RC200.getMessage()) : ResultData.error(ReturnCode.RC999.getMessage());
    }

    @ApiOperation(value = "修改用户密码")
    @PostMapping("resetPwd")
    public ResultData<String> resetPwd(@Valid @RequestBody SysUserDTO user) {
        boolean save = sysUserService.resetPwd(user);
        return save ? ResultData.success(ReturnCode.RC200.getMessage()) : ResultData.error(ReturnCode.RC999.getMessage());
    }

    @ApiOperation(value = "根据ID，批量删除用户信息")
    @PostMapping("/deletes")
    public ResultData<String> deletes(@Valid @NotNull @Size(min = 1, message = "主键长度最小为1") @RequestBody List<String> userIds) {
        boolean remove = sysUserService.removeBatchByIds(userIds);
        return remove ? ResultData.success(ReturnCode.RC200.getMessage()) : ResultData.error(ReturnCode.RC999.getMessage());
    }

    @ApiOperation(value = "根据ID，删除用户信息")
    @PostMapping("/delete")
    public ResultData<String> delete(@Valid @NotEmpty(message = "ID不能为空") @RequestBody String userId) {
        boolean remove = sysUserService.removeById(userId);
        return remove ? ResultData.success(ReturnCode.RC200.getMessage()) : ResultData.error(ReturnCode.RC999.getMessage());
    }

    @GetMapping("logOut")
    public ResultData<String> logOut() {
        StpUtil.logout();
        return ResultData.success("注销成功");
    }


    // 查询登录状态，浏览器访问： http://localhost:8082/user/isLogin
    @GetMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    // 查询 Token 信息  ---- http://localhost:8082/acc/tokenInfo
    @GetMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }



}
