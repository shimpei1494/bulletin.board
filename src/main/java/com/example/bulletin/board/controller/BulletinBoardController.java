package com.example.bulletin.board.controller;

import com.example.bulletin.board.entity.CustomPostEntity;
import com.example.bulletin.board.entity.gen.Post;
import com.example.bulletin.board.logic.PostCreateLogic;
import com.example.bulletin.board.logic.PostUpdateLogic;
import com.example.bulletin.board.model.form.BulletinBoardPostForm;
import com.example.bulletin.board.model.view.BoardView;
import com.example.bulletin.board.service.AccountService;
import com.example.bulletin.board.service.BulletinBoardService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BulletinBoardController {

    private BulletinBoardService bulletinBoardService;

    private AccountService accountService;

    private PostCreateLogic postCreateLogic;

    private PostUpdateLogic postUpdateLogic;

    public BulletinBoardController(BulletinBoardService bulletinBoardService, AccountService accountService, PostCreateLogic postCreateLogic, PostUpdateLogic postUpdateLogic) {
        this.bulletinBoardService = bulletinBoardService;
        this.accountService = accountService;
        this.postCreateLogic = postCreateLogic;
        this.postUpdateLogic = postUpdateLogic;
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
        mav.addObject("form", new BulletinBoardPostForm());
        return mav;
    }

    @GetMapping("edit/{postId}")
    public ModelAndView edit(@PathVariable Integer postId, ModelAndView mav) {
        // idから既存のデータを取得して編集画面に遷移
        Post post = bulletinBoardService.getPostById(postId);
        BulletinBoardPostForm form = new BulletinBoardPostForm();
        form.setPostId(postId);
        form.setContent(post.getContent());
        mav.addObject("form", form);
        mav.setViewName("board/post");
        return mav;
    }

    // 新規作成または更新時
    @PostMapping("post")
    public ModelAndView post(@ModelAttribute BulletinBoardPostForm form,
                             @AuthenticationPrincipal UserDetails userDetails,
                             ModelAndView mav) {
        // リクエストパラメータの解析
        Integer postId = form.getPostId();
        String content = form.getContent();
        String name = userDetails.getUsername();

        int result = 0;
        String successMsg;
        String errorMsg;

        if (postId == null) {
            // 新規作成時
            result = postCreateLogic.execute(content, name);
            successMsg = "データの登録に成功しました";
            errorMsg = "データの登録に失敗しました";
        } else {
            // 更新時
            result = postUpdateLogic.execute(postId, content);
            successMsg = "データの更新に成功しました";
            errorMsg = "データの更新に失敗しました";
        }


        if (result == 1) {
            mav.addObject("successMsg", successMsg);
        } else {
            mav.addObject("errorMsg", errorMsg);
        }
        mav.addObject("form", form);
        mav.setViewName("board/post");

        return mav;
    }

}
