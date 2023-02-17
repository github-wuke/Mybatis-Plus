package com.wuke.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.wuke.entity.TUser;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 在进行数据更改的时候向数据库插入一个字段的默认值
 * @author wuke
 * @date 2021年08月29日 11:20
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    //使用mp实现insert操作，这个方法执行
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Date(),metaObject);
    }

    //使用mp实现update操作，这个方法执行
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
