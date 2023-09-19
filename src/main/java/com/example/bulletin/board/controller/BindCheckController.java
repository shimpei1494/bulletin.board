package com.example.bulletin.board.controller;

import com.example.bulletin.board.model.form.BindCheckForm1;
import com.example.bulletin.board.model.form.BindCheckForm2;
import com.example.bulletin.board.model.form.BindCheckForm3;
import com.example.bulletin.board.model.form.BindCheckForm4;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bind")
public class BindCheckController {

    public BindCheckController() {
    }

    @GetMapping("/check")
    public ModelAndView check(ModelAndView mav) {
        mav.setViewName("bind_check/index");
        mav.addObject("form", new BindCheckForm1());
        return mav;
    }


    @PostMapping("/check1")
    public ModelAndView check1(@ModelAttribute BindCheckForm1 form, ModelAndView mav) {
        mav.setViewName("bind_check/result");
        return mav;
    }

    @PostMapping("/check2")
    public ModelAndView check2(@ModelAttribute BindCheckForm2 form, ModelAndView mav) {
        mav.setViewName("bind_check/result");
        return mav;
    }

    @PostMapping("/check3")
    public ModelAndView check3(@ModelAttribute BindCheckForm3 form, ModelAndView mav) {
        mav.setViewName("bind_check/result");
        return mav;
    }

    @PostMapping("/check4")
    public ModelAndView check4(@ModelAttribute BindCheckForm4 form, ModelAndView mav) {
        mav.setViewName("bind_check/result");
        return mav;
    }


}
