package com.example.bulletin.board.controller;

import com.example.bulletin.board.entity.gen.Post;
import com.example.bulletin.board.logic.CreatePostLogic;
import com.example.bulletin.board.logic.GetPostListLogic;
import com.example.bulletin.board.logic.UpdatePostLogic;
import com.example.bulletin.board.model.form.*;
import com.example.bulletin.board.model.view.BoardView;
import com.example.bulletin.board.service.BulletinBoardService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bind")
public class BindCheckController {

    private BulletinBoardService bulletinBoardService;

    private GetPostListLogic getPostListLogic;

    private CreatePostLogic createPostLogic;

    private UpdatePostLogic updatePostLogic;

    public BindCheckController(BulletinBoardService bulletinBoardService, GetPostListLogic getPostListLogic, CreatePostLogic createPostLogic, UpdatePostLogic updatePostLogic) {
        this.bulletinBoardService = bulletinBoardService;
        this.getPostListLogic = getPostListLogic;
        this.createPostLogic = createPostLogic;
        this.updatePostLogic = updatePostLogic;
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
