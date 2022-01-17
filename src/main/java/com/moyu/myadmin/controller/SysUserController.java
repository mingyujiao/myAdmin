package com.moyu.myadmin.controller;


import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.moyu.myadmin.entity.SysUserEntity;
import com.moyu.myadmin.service.SysUserService;
import com.moyu.myadmin.utils.ResultData;
import com.moyu.myadmin.utils.ReturnCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@Api(tags="用户管理")
@RestController
@RequestMapping("/sysUser/")
public class SysUserController {

    private final SysUserService sysUserService;

    @Autowired
    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @ApiOperation("查询所有用户信息")
    @PostMapping("queryList")
    public ResultData<List<SysUserEntity>> queryList(SysUserEntity entity) {
        List<SysUserEntity> userEntities = sysUserService.queryList(entity);
        return ResultData.success(userEntities);
    }

    @ApiOperation("用户登录")
    @PostMapping("doLogin")
    public ResultData<String> doLogin(@RequestBody @Valid SysUserEntity entity) {
        boolean loginFlag = sysUserService.doLogin(entity);
        return loginFlag ? ResultData.success("登录成功") : ResultData.error(ReturnCode.RC999.getCode(), "登录失败");
    }

    @ApiOperation("添加用户")
    @PostMapping("save")
    public ResultData<SysUserEntity> save(@ApiParam(value = "用户信息") @Valid SysUserEntity user) {
        boolean save = sysUserService.saveUser(user);
        return save ? ResultData.success(user) : ResultData.error(ReturnCode.RC999.getCode(), ReturnCode.RC999.getMessage());
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

    // 测试注销  ---- http://localhost:8082/user/logout
    @GetMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

}
