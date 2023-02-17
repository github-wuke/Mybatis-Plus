package com.wuke.controller;

import com.wuke.entity.TUser;
import com.wuke.service.UserService;
import com.wuke.responce.Responce;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuke
 * @date 2021年08月29日 1:12
 */
@Slf4j
@RestController
@Api(tags = "用户管理")
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("批量新增用户")
    @PostMapping("/addBatch")
    public Responce<?> addUserBatch(@RequestBody List<TUser> user) {
        return userService.addUserBatch(user) ? Responce.success() : Responce.fail();
    }

    @ApiOperation("优化批量新增用户")
    @PostMapping("/addBatch/Optimize")
    public Responce<?> addOptimizeUserBatch(@RequestBody List<TUser> user) {
        return userService.addOptimizeUserBatch(user) ? Responce.success() : Responce.fail();
    }

    /**
     * 分页查询方式一:使用Mybatis-Plus自行进行单表分页
     */
    @ApiOperation("单表分页查询")
    @GetMapping("/page1")
    public Responce<?> findUserPage1(Integer current, Integer size, String username) {
        return Responce.success(userService.findUserPage1(current, size, username));
    }

    /**
     * 分页查询方式二:使用Mybatis以及Mybatis-Plus对象进行多表分页
     */
    @ApiOperation("多表分页查询一")
    @GetMapping("/page2")
    public Responce<?> findUserPage2(Integer current, Integer size, String username) {
        return Responce.success(userService.findUserPage2(current, size, username));
    }

    /**
     * 分页查询方式二:使用Mybatis以及Mybatis-Plus对象进行多表分页
     */
    @ApiOperation("多表分页查询二")
    @GetMapping("/page3")
    public Responce<?> findUserPage3(Integer current, Integer size, String username) {
        return Responce.success(userService.findUserPage3(current, size, username));
    }

}
