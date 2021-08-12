package com.zhang.security.exception;

import org.springframework.security.core.AuthenticationException;

import javax.servlet.ServletException;

/**
 * @author zhang
 * @date 2021/8/11
 * @apiNote
 */
public class CaptchaException extends AuthenticationException {

    public CaptchaException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public CaptchaException(String msg) {
        super(msg);
    }

    public  CaptchaException(){
        super("验证码错误！");
    }
}
