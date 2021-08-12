package com.zhang.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhang.security.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhang
 * @date 2021/8/9
 * @apiNote
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    @Select("select " +
            "   r.id, r.rolename, r.roleinfo, r.gmt_created, r.gmt_modified " +
            "from " +
            "   sys_role r, sys_relation rl " +
            "where " +
            "   rl.userid = #{userid} and " +
            "   rl.roleid = r.id;")
    List<SysRole> selectRolesByUserid(@Param("userid")Integer userid);

    @Select("select " +
            "   r.id, r.rolename, r.roleinfo, r.gmt_created, r.gmt_modified " +
            "from " +
            "   sys_role r, sys_user u, sys_relation rl " +
            "where " +
            "   u.username = #{username} and " +
            "   u.id = rl.userid and " +
            "   rl.roleid = r.id;")
    List<SysRole> selectRolesByUsername(@Param("username")String username);
}