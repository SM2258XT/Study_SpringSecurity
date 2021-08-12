package com.zhang.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhang.security.domain.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhang
 * @date 2021/8/8
 * @apiNote
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
