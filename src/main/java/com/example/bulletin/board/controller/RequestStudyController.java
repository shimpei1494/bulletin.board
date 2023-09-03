package com.example.bulletin.board.controller;

import com.example.bulletin.board.model.form.RequestStudyForm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/request")
public class RequestStudyController {

    public RequestStudyController() {
    }

    @GetMapping("/")
    public String index() {
        return "request_study/index";
    }

    @PostMapping("/action1")
    public ModelAndView action1(@RequestParam String like,
                                @RequestParam("unlike") String notLike,
                                ModelAndView mav) {
        // 引数の変数名とリクエストのname属性が同じなら@RequestParamをつけなくてもパラメータ受け取ってくれる
        mav.setViewName("request_study/check");
        mav.addObject("like", like);
        mav.addObject("notLike", notLike);
        return mav;
    }

    @GetMapping("/action2/{paramName}")
    public ModelAndView action2(@PathVariable String paramName,
                                ModelAndView mav) {
        // URLの{paramName}の部分が引数のparamNameに代入される
        mav.setViewName("request_study/check2");
        mav.addObject("message", paramName);
        return mav;
    }

    @PostMapping("/action3")
    public ModelAndView action3(@ModelAttribute RequestStudyForm form,
                                ModelAndView mav) {
        // @ModelAttributeがあってもなくても、formのフィールド名がリクエストのname属性と一致していれば受け取れるみたい
        mav.setViewName("request_study/check3");
        mav.addObject("food", form.getFood());
        mav.addObject("trip", form.getTrip());
        return mav;
    }

    @PostMapping("/action4")
    public ModelAndView action4(HttpServletRequest req,
                                ModelAndView mav) {
        mav.setViewName("request_study/check4");
        // リクエストパラメータのnameキーのvalueを取得
        String name = req.getParameter("name");
        mav.addObject("name", name);
        return mav;
    }



}
