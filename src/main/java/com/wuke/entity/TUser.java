package com.wuke.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

/**
 * @author wuke
 * @date 2021年08月28日 23:16
 */
@Data
@Builder
@TableName(value = "t_user")
@NoArgsConstructor
@AllArgsConstructor
public class TUser {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer cityId;
    private String userName;
    private String password;
    private String phone;
    private Boolean disabled;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(exist = false)
    private List<TRole> roles;

}
