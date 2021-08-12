package com.zhang.security.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * @author zhang
 * @date 2021/8/8
 * @apiNote
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRole {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String rolename;
    private String roleinfo;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreated;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    public SysRole(String rolename, String roleinfo) {
        this.rolename = rolename;
        this.roleinfo = roleinfo;
    }
}
