package com.zhang.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhang.security.vo.CaptchaResponseModel;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhang
 * @date 2021/8/10
 * @apiNote
 */
@Component
public class MyAjaxLoginFailureHandler implements AuthenticationFailureHandler {
    private boolean captchaCheckedFailed = false;

    public MyAjaxLoginFailureHandler() {
    }

    public void setCaptchaVerifyFailed() {
        this.captchaCheckedFailed = true;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        PrintWriter pw = httpServletResponse.getWriter();
        CaptchaResponseModel model = null;
        if (captchaCheckedFailed)
            model = new CaptchaResponseModel(2, "captcha error!");
        else
            model = new CaptchaResponseModel(1, "account error!");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(model);
        System.out.println(json);
        pw.write(json);
    }
}
