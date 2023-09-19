package com.example.bulletin.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/redirect_check")
public class RedirectCheckController {

    public RedirectCheckController() {
    }

    @GetMapping("/")
    public ModelAndView check(@ModelAttribute("word") String word, ModelAndView mav) {
        mav.addObject("word", word);
        mav.setViewName("redirect_check/index");
        return mav;
    }

    @PostMapping("/submit")
    public String check(@RequestParam String word, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("word", word);
        // 以下でもリダイレクト先に値を渡すことができた
        // redirectAttributes.addAttribute("word", word);
        return "redirect:/redirect_check/";
    }

}
