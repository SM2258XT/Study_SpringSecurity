package com.zhang.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhang
 * @date 2021/8/9
 * @apiNote
 */
@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('admin')")
public class AdminController {
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "admin - index";
    }
}
