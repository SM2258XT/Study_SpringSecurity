package com.zhang.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhang.security.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhang
 * @date 2021/8/9
 * @apiNote
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}