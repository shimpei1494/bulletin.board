package com.example.bulletin.board.controller;

import com.example.bulletin.board.dao.AccountDao;
import com.example.bulletin.board.dao.PostDao;
import com.example.bulletin.board.entity.CustomPostEntity;
import com.example.bulletin.board.model.form.BulletinBoardPostForm;
import com.example.bulletin.board.model.view.BoardView;
import com.example.bulletin.board.service.AccountService;
import com.example.bulletin.board.service.BulletinBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BulletinBoardController {

    @Autowired
    private PostDao postDao;

    @Autowired
    private AccountDao accountDao;

    private BulletinBoardService bulletinBoardService;

    private AccountService accountService;

    public BulletinBoardController(BulletinBoardService bulletinBoardService, AccountService accountService) {
        this.bulletinBoardService = bulletinBoardService;
        this.accountService = accountService;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("board/index");
        var view = new BoardView();
        // TODO　既存の1データしか取得する実装になっていないのでカスタムマッパーで掲示板のデータを全て取得する
        String searchWord = "";
        List<CustomPostEntity> list = bulletinBoardService.getPostList(searchWord);
        view.setList(list);
        mav.addObject("view", view);
        return mav;
    }


    @GetMapping("/new")
    public ModelAndView create(ModelAndView mav) {
        mav.setViewName("board/post");
        mav.addObject("view", new BulletinBoardPostForm());
        return mav;
    }

    @GetMapping("edit")
    public ModelAndView edit(ModelAndView mav) {
        mav.setViewName("board/post");
        return mav;
    }

    @PostMapping("post")
    public ModelAndView post(@ModelAttribute BulletinBoardPostForm form,
                             @AuthenticationPrincipal UserDetails userDetails,
                             ModelAndView mav) {
        String name = userDetails.getUsername();
        String content = form.getContent();

        int accountId = accountService.getAccountIdByAccountName(name);
        int result = 0;
        if (accountId != -1) {
            result = bulletinBoardService.createPost(accountId, content);
        }
        mav.setViewName("redirect:/board/");
        return mav;
    }

}
