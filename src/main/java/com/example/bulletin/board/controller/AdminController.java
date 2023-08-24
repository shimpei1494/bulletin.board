package com.example.bulletin.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    @GetMapping("role_check")
    public String roleCheck(Model model) {
        return "admin/role_check";
    }


}
