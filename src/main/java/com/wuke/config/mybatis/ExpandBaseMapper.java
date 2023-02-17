package com.wuke.config.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.Collection;

public interface ExpandBaseMapper <T> extends BaseMapper<T> {

    Integer insertBatchSomeColumn(Collection<T> entityList);
}
