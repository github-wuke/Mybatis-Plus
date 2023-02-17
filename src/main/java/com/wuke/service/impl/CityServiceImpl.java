package com.wuke.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuke.entity.TCity;
import com.wuke.mapper.CityMapper;
import com.wuke.service.CityService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, TCity> implements CityService {

    @Resource
    private CityMapper cityMapper;

    @Override
    public List<Tree<String>> findAllCity() {

        // 查询出所有的数据集合
        List<TCity> parentCityList = cityMapper.selectList(null);

        // 配置 TreeNodeConfig
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setIdKey("id");
        treeNodeConfig.setParentIdKey("pid");
        treeNodeConfig.setChildrenKey("children");
        //treeNodeConfig.setWeightKey();权重占比
        //treeNodeConfig.setDeep(5);最大递归深度

        // 树结够转换器
        return TreeUtil.build(parentCityList, "0", treeNodeConfig,
                (treeNode, tree) -> {
                    tree.setId(String.valueOf(treeNode.getId()));
                    tree.setParentId(String.valueOf(treeNode.getCityPid()));
                    tree.setName(treeNode.getCityName());
                    // 扩展属性 ...
                    tree.putExtra("combinationName", treeNode.getCombinationName());
                });
    }
}
