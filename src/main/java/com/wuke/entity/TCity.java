package com.wuke.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@TableName(value = "t_city")
@NoArgsConstructor
@AllArgsConstructor
public class TCity {

    private Integer id;

    private String cityName;

    private Integer cityPid;

    private String sname;

    private String combinationName;

    @TableField(exist = false)
    private List<TCity> cityChildren;
}
