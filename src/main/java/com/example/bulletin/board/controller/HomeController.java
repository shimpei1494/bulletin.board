package com.example.bulletin.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView mav,
                              @RequestParam(value = "error", required = false) String error) {
        mav.setViewName("login");
        if (error != null) {
            mav.addObject("msg", "ログインできませんでした");
        } else {
            mav.addObject("msg", "ユーザー名とパスワードを入力");
        }
        return mav;
    }

}
