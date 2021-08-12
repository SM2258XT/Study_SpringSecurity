package com.zhang.security.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhang.security.domain.SysRelation;
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
public class InsertTest {
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysRoleMapper sysRoleMapper;
    @Autowired
    SysRelationMapper sysRelationMapper;

    @Test
    void insertUsers() {
        List<SysUser> users = new ArrayList<>();
        users.add(new SysUser("root", "zhang", "张三", true, true, true, true));
        users.add(new SysUser("jack", "666", "杰克", true, true, true, true));
        users.add(new SysUser("tom", "666", "汤姆", true, true, true, true));
        users.forEach(sysUserMapper::insert);
    }

    @Test
    void insertRoles() {
        List<SysRole> roles = new ArrayList<>();
        roles.add(new SysRole("visitor", "访客"));
        roles.add(new SysRole("customer", "顾客"));
        roles.add(new SysRole("staff", "职员"));
        roles.add(new SysRole("admin", "系统管理员"));
        roles.forEach(sysRoleMapper::insert);
    }

    @Test
    void insertRelations() {
        SysUser root = sysUserMapper.selectOne(new QueryWrapper<SysUser>().eq("username", "root"));
        SysUser jack = sysUserMapper.selectOne(new QueryWrapper<SysUser>().eq("username", "jack"));
        SysUser tom = sysUserMapper.selectOne(new QueryWrapper<SysUser>().eq("username", "tom"));

        SysRole visitor = sysRoleMapper.selectOne(new QueryWrapper<SysRole>().eq("rolename", "visitor"));
        SysRole customer = sysRoleMapper.selectOne(new QueryWrapper<SysRole>().eq("rolename", "customer"));
        SysRole staff = sysRoleMapper.selectOne(new QueryWrapper<SysRole>().eq("rolename", "staff"));
        SysRole admin = sysRoleMapper.selectOne(new QueryWrapper<SysRole>().eq("rolename", "admin"));

        //root的权限为：visitor、customer、staff、admin、
        int rootID = root.getId();
        List<SysRelation> rootRelations = new ArrayList<>();
        rootRelations.add(new SysRelation(rootID, visitor.getId()));
        rootRelations.add(new SysRelation(rootID, customer.getId()));
        rootRelations.add(new SysRelation(rootID, staff.getId()));
        rootRelations.add(new SysRelation(rootID, admin.getId()));
        rootRelations.forEach(sysRelationMapper::insert);

        //jack的角色为：visitor、customer、staff
        int jackID = jack.getId();
        List<SysRelation> jackRelations = new ArrayList<>();
        jackRelations.add(new SysRelation(jackID, visitor.getId()));
        jackRelations.add(new SysRelation(jackID, customer.getId()));
        jackRelations.add(new SysRelation(jackID, staff.getId()));
        jackRelations.forEach(sysRelationMapper::insert);

        //tom的角色为：visitor
        int tomID = tom.getId();
        List<SysRelation> tomRelations = new ArrayList<>();
        tomRelations.add(new SysRelation(tomID, visitor.getId()));
        tomRelations.forEach(sysRelationMapper::insert);
    }
}
