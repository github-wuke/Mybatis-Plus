package com.wuke.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuke.entity.TUser;
import com.wuke.mapper.UserMapper;
import com.wuke.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuke
 * @date 2021年08月29日 0:34
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, TUser> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Boolean addUserBatch(List<TUser> user) {
        return userMapper.insertBatchSomeColumn(user) > 0;
    }

    @Override
    public boolean addOptimizeUserBatch(List<TUser> user) {
        return this.saveBatch(user);
    }

    @Override
    public IPage findUserPage1(Integer current, Integer size, String username) {
        IPage page = new Page(current, size);
        LambdaQueryWrapper<TUser> lqw = Wrappers.<TUser>lambdaQuery().like(StringUtils.hasText(username), TUser::getUserName, username);
        return userMapper.selectPage(page, lqw);
    }

    @Override
    public IPage findUserPage2(Integer current, Integer size, String username) {
        Page page = new Page(current, size);
        return userMapper.selectPage2(page, username);
    }

    @Override
    public IPage findUserPage3(Integer current, Integer size, String username) {
        Page page = new Page(current, size);
        LambdaQueryWrapper<TUser> lqw = Wrappers.<TUser>lambdaQuery().like(StringUtils.hasText(username), TUser::getUserName, username);
        return userMapper.findUserPage3(page, lqw);
    }
}