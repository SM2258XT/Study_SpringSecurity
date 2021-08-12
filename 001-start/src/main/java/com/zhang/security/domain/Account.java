package com.zhang.security.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhang
 * @date 2021/8/8
 * @apiNote
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;
    private String password;
    private String role;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreated;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}

