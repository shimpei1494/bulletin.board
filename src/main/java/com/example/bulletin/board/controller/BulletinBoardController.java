package com.example.bulletin.board.controller;

import com.example.bulletin.board.dao.PostDao;
import com.example.bulletin.board.entity.gen.Post;
import com.example.bulletin.board.model.view.BoardView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BulletinBoardController {

    @Autowired
    private PostDao postDao;

    public BulletinBoardController() {
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("board/index");
        var view = new BoardView();
        Post entity = postDao.selectPk(3);
        view.setUserName("ooshita");
        view.setContent(entity.getContent());
        mav.addObject("view", view);
        return mav;
    }


    @GetMapping("/new")
    public ModelAndView create(ModelAndView mav) {
        mav.setViewName("board/post");
        mav.addObject("view", new BoardView());
        return mav;
    }

    @GetMapping("edit")
    public ModelAndView edit(ModelAndView mav) {
        mav.setViewName("board/post");
        return mav;
    }

    @PostMapping("post")
    public ModelAndView post(@RequestParam String content, ModelAndView mav) {
        // 処理させて完了したら編集画面に遷移し、成功メッセージ
        postDao.create(content);
        mav.setViewName("redirect:/board/");
        return mav;
    }

}
