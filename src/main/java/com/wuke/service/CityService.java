package com.wuke.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wuke.entity.TCity;

import java.util.List;

public interface CityService extends IService<TCity> {
    List<Tree<String>> findAllCity();
}
