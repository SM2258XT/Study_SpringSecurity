package com.zhang.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhang.security.vo.CaptchaResponseModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
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
public class MyAjaxLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        PrintWriter pw = httpServletResponse.getWriter();
        CaptchaResponseModel model = new CaptchaResponseModel(0, "success!");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(model);
        System.out.println("====================");
        System.out.println(json);
        pw.write(json);
    }
}
