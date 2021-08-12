package com.zhang.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhang.security.domain.Account;
import com.zhang.security.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang
 * @date 2021/8/8
 * @apiNote
 */
@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    AccountMapper accountMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        //用户名为空
        if (username != null) {
            QueryWrapper<Account> wrapper = new QueryWrapper<>();
            wrapper.eq("username", username);
            Account account = accountMapper.selectOne(wrapper);
            //查到了该账户的记录
            if (account != null) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                //角色名必须以ROLE_开头！！
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + account.getRole());
                authorities.add(authority);

                String codedPassword = new BCryptPasswordEncoder().encode(account.getPassword());
                user = new User(account.getUsername(), codedPassword, authorities);
            }
        }
        return user;
    }
}
