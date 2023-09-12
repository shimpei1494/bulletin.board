package com.example.bulletin.board.service;

import com.example.bulletin.board.dao.PostDao;
import com.example.bulletin.board.entity.CustomPostEntity;
import com.example.bulletin.board.entity.gen.Post;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BulletinBoardService {
    private PostDao postDao;

    public BulletinBoardService(PostDao postDao) {
        this.postDao = postDao;
    }

    // 掲示板一覧取得メソッド
    public List<CustomPostEntity> getPostList(@Nullable String searchWord) {
        return postDao.getPostList(searchWord);
    }

    public Post getPostById(Integer id) {
        return postDao.selectPk(id);
    }

    public int createPost(int accountId, String content) {
        return postDao.insert(accountId, content);
    }

    public int updatePost(int editPostId, String content) {
        return postDao.update(editPostId, content);
    }




}
