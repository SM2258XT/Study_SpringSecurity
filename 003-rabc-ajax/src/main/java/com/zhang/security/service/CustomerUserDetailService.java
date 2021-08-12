package com.zhang.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhang.security.domain.SysRole;
import com.zhang.security.domain.SysUser;
import com.zhang.security.mapper.SysRoleMapper;
import com.zhang.security.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang
 * @date 2021/8/9
 * @apiNote
 */
@Service
public class CustomerUserDetailService implements UserDetailsService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null)
            throw new UsernameNotFoundException("用户名为空！");

        SysUser user = sysUserMapper.selectOne(new QueryWrapper<SysUser>().eq("username", username));
        if (user == null)
            throw new UsernameNotFoundException("不存在用户【" + username + "】");

        List<SysRole> roles = sysRoleMapper.selectRolesByUserid(user.getId());
        if (roles == null)
            throw new UsernameNotFoundException("用户【" + username + "】没有任何角色！");

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (SysRole role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRolename()));
        }
        user.setAuthorities(authorities);
        //把用户的密码取出来进行加密，然后再保存。
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return user;
    }
}
