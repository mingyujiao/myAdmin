package com.moyu.myadmin.controller;


import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.moyu.myadmin.entity.SysUserEntity;
import com.moyu.myadmin.service.SysUserService;
import com.moyu.myadmin.utils.ResultData;
import com.moyu.myadmin.utils.ReturnCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @ApiOperation(value = "获取用户信息")
    @PostMapping("getUser")
    public ResultData<SysUserEntity> getUser(SysUserEntity entity) {
        entity = sysUserService.getById(entity.getUserId());
        SaSession session = StpUtil.getTokenSession();
        log.info("当前登录用户的用户ID：{}", session.get("userId"));
        return ResultData.success(entity);
    }

    @ApiOperation(value = "查询所有用户信息")
    @PostMapping("queryList")
    public ResultData<List<SysUserEntity>> queryList(SysUserEntity entity) {
        List<SysUserEntity> userEntities = sysUserService.queryList(entity);
        return ResultData.success(userEntities);
    }

    @ApiImplicitParam(name = "entity", value = "登录信息", required = true)
    @ApiOperation(value = "用户登录")
    @PostMapping("doLogin")
    public ResultData<Object> doLogin(@RequestBody SysUserEntity entity) {
        boolean loginFlag = sysUserService.doLogin(entity);
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return loginFlag ? ResultData.success(tokenInfo) : ResultData.error(ReturnCode.RC999.getCode(), "登录失败");
    }

    @ApiOperation(value = "添加用户")
    @PostMapping("save")
    public ResultData<SysUserEntity> save(@ApiParam(value = "用户信息") @Valid SysUserEntity user) {
        boolean save = sysUserService.saveUser(user);
        return save ? ResultData.success(user) : ResultData.error(ReturnCode.RC999.getCode(), ReturnCode.RC999.getMessage());
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
