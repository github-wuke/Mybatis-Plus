package com.wuke.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author wuke
 * @date 2021年08月28日 23:39
 */
@Data
@TableName(value = "t_role")
@NoArgsConstructor
@AllArgsConstructor
public class TRole {

    @TableId(type = IdType.AUTO)
    private String id;

    @TableField(value = "role_name")
    private String roleName;

    private String disabled;

    @TableField(value = "create_time")
    private Date createTime;
}
