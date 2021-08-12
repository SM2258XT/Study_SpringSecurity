package com.zhang.security.controller;

import com.zhang.security.utils.CaptchaUtil;
import com.zhang.security.vo.CaptchaResponseModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Map;

/**
 * @author zhang
 * @date 2021/8/10
 * @apiNote
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest req, HttpServletResponse res) {
        res.setHeader("Pragma", "No-cache");
        res.setHeader("Cache-Control", "no-cache");
        res.setDateHeader("Expires", 0);
        res.setContentType("image/jpeg");
        String captchaCode = CaptchaUtil.generateVerifyCode(4);
        try {
            HttpSession session = req.getSession();
            session.setAttribute("captcha", captchaCode.toUpperCase());
            OutputStream outputStream = res.getOutputStream();
            CaptchaUtil.outputImage(110, 40, outputStream, captchaCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/loginTest.do")
    @ResponseBody
    public Object loginTest(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username：");
        System.out.println(username);
        System.out.println("password：");
        System.out.println(password);
        return new CaptchaResponseModel(0, "success（loginTest）！");
    }

}