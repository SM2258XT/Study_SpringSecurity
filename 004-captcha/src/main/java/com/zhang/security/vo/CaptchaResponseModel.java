package com.zhang.security.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhang
 * @date 2021/8/11
 * @apiNote
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaptchaResponseModel implements Serializable {
    private Integer code;
    private String msg;
}
