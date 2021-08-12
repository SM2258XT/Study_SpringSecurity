package com.zhang.security.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhang
 * @date 2021/8/9
 * @apiNote
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRelation {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer userid;
    private Integer roleid;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreated;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    public SysRelation(Integer userid, Integer roleid) {
        this.userid = userid;
        this.roleid = roleid;
    }
}
