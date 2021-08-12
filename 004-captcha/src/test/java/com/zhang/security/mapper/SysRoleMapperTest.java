package com.zhang.security.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhang.security.domain.SysRole;
import com.zhang.security.domain.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang
 * @date 2021/8/9
 * @apiNote
 */
@SpringBootTest
class SysRoleMapperTest {
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysRoleMapper sysRoleMapper;

    @Test
    void testSelectRolesByUserid(){
        SysUser root = sysUserMapper.selectOne(new QueryWrapper<SysUser>().eq("username", "root"));
        List<SysRole> rootRoles = sysRoleMapper.selectRolesByUserid(root.getId());
        rootRoles.forEach(System.out::println);
    }

    @Test
    void testSelectRolesByUsername(){
        List<SysRole> rootRoles = sysRoleMapper.selectRolesByUsername("root");
        rootRoles.forEach(System.out::println);
    }
}