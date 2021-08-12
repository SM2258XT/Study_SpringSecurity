package com.zhang.security.filter;

import com.zhang.security.config.MyAjaxLoginFailureHandler;
import com.zhang.security.exception.CaptchaException;
import com.zhang.security.utils.WebUtil;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author zhang
 * @date 2021/8/11
 * @apiNote
 */
public class CaptchaFilter extends OncePerRequestFilter {
    MyAjaxLoginFailureHandler failureHandler = new MyAjaxLoginFailureHandler();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //filterChain.doFilter(request, response);

        //只有请求为/login.do，才检查验证码。这个uri必须与处理器里的登录处理地址相同
        String uri = request.getRequestURI();
        if (!"/login.do".equals(uri)) {
            filterChain.doFilter(request, response);
            return;
        }
        System.out.println("==========" + uri);

        if (verifyCaptchaCorrectly(request)) {
            filterChain.doFilter(request, response);
        } else {
            CaptchaException captchaException = new CaptchaException();
            failureHandler.setCaptchaVerifyFailed();
            failureHandler.onAuthenticationFailure(request, response, captchaException);
        }
    }

    private boolean verifyCaptchaCorrectly(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String correctCaptcha = (String) session.getAttribute("captcha");
        String inputCaptcha = request.getParameter("captcha");
        if (!WebUtil.notNullOrEmpty(correctCaptcha, inputCaptcha)) {
            return false;
        }
        //验证码正确
        if (correctCaptcha.equals(inputCaptcha.trim().toUpperCase())) {
            session.removeAttribute("captcha");
            return true;
        }
        return false;
    }
}
