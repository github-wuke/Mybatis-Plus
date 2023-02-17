package com.wuke.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.wuke.config.mybatis.ExpandBaseMapper;
import com.wuke.entity.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends ExpandBaseMapper<TUser>  {
    /**
     * Page对象必须放在参数参数1的位置，否则分页失
     */
    IPage selectPage2(IPage page, @Param("username") String username);
    IPage findUserPage3(IPage page, @Param(Constants.WRAPPER) Wrapper wrapper);

}
