package com.wuke.config.mybatis;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * SQL注入器:
 *      继承DefaultSqlInjector类,可以获取到BaseMapper原有的方法。
 *      重写getMethodList方法,也可以添加自己的方法。
 */
@Component
public class ExpandSqlInjector extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {

        // 注意:此SQL注入器继承了DefaultSqlInjector(默认注入器)，调用了DefaultSqlInjector的getMethodList方法，保留了mybatis-plus的自带方法
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);

        // 注入InsertBatchSomeColumn,该方法优化mp批量插入数据时一条一条插入的问题
        // !t.isLogicDelete()表示不要逻辑删除字段，!"update_time".equals(t.getColumn())表示不要字段名为 update_time 的字段
        methodList.add(new InsertBatchSomeColumn(t -> !t.isLogicDelete() && !"update_time".equals(t.getColumn())));
        return methodList;
    }
}

