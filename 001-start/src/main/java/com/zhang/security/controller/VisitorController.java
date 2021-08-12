package com.zhang.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhang
 * @date 2021/8/8
 * @apiNote
 */
@Controller
@RequestMapping("/visitor")
public class VisitorController {
    @RequestMapping("/index")
    @PreAuthorize("hasAnyRole('visitor','admin')")
    @ResponseBody
    public String index() {
        return "index：'visitor','admin'";
    }
}
