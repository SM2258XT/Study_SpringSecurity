package com.zhang.security.config;

import com.zhang.security.filter.CaptchaFilter;
import com.zhang.security.service.CustomerUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author zhang
 * @date 2021/8/9
 * @apiNote
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomerUserDetailService userDetailService;
    @Autowired
    MyAjaxLoginSuccessHandler myAjaxLoginSuccessHandler;
    @Autowired
    MyAjaxLoginFailureHandler myAjaxLoginFailureHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String loginPage = "/login.html";
        String loginUrl = "/login.do";
        //设置请求的拦截规则
        http.authorizeRequests()
                //静态资源全部放行
                .antMatchers("/api/**", "/css/**", "/images/**", "/js/**", "/lib/**").permitAll()
                .antMatchers("/public/**", "/login/**").permitAll()
                //登录页面和登录表单提交URL需要放行
                .antMatchers(loginPage, loginUrl).permitAll()
                //其他请求需要身份认证
                .anyRequest().authenticated();
        //设置登入登出相关信息
        http.formLogin().loginPage(loginPage).loginProcessingUrl(loginUrl)
                .successHandler(myAjaxLoginSuccessHandler).failureHandler(myAjaxLoginFailureHandler);
        http.csrf().disable();  //关闭csrf恶意跨域攻击防护

        http.addFilterBefore(new CaptchaFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
