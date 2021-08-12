package com.zhang.security.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @author zhang
 * @date 2021/8/8
 * @apiNote
 */
@Configuration
public class MyBatisPlusConfig implements MetaObjectHandler {
    public void insertFill(MetaObject metaObject) {
        //进行插入操作时，会自动填充表中的gmtCreated和gmtModified字段。
        this.setFieldValByName("gmtCreated", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }

    public void updateFill(MetaObject metaObject) {
        //进行更新操作时，只用自动填充updateTime字段。
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
