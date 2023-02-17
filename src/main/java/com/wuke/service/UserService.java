package com.wuke.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wuke.entity.TUser;
import java.util.List;

public interface UserService extends IService<TUser> {

    Boolean addUserBatch(List<TUser> user);

    boolean addOptimizeUserBatch(List<TUser> user);

    IPage findUserPage1(Integer current, Integer size, String username);

    IPage findUserPage2(Integer current, Integer size, String username);

    IPage findUserPage3(Integer current,Integer size,String username);

}
