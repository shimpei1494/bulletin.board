package com.example.bulletin.board.controller;

import com.example.bulletin.board.model.form.BindCheckForm1;
import com.example.bulletin.board.model.form.BindCheckForm2;
import com.example.bulletin.board.model.form.BindCheckForm3;
import com.example.bulletin.board.model.form.BindCheckForm4;
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
        return "redirect:/redirect_check/";
    }

}
