package com.zhang.security.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author zhang
 * @date 2021/8/8
 * @apiNote
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements UserDetails {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;
    private String password;
    private String realname;

    private boolean isEnabled;
    private boolean isCredentials;
    private boolean isNonExpired;
    private boolean isNonLocked;

    @TableField(exist = false)      //忽略权限字段
    List<GrantedAuthority> authorities;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreated;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    public SysUser(String username, String password, String realname, boolean isEnabled, boolean isCredentials, boolean isNonExpired, boolean isNonLocked) {
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.isEnabled = isEnabled;
        this.isCredentials = isCredentials;
        this.isNonExpired = isNonExpired;
        this.isNonLocked = isNonLocked;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentials;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }
}
