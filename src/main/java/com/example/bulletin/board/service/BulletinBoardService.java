package com.example.bulletin.board.service;

import com.example.bulletin.board.dao.AccountDao;
import com.example.bulletin.board.dao.PostDao;
import com.example.bulletin.board.entity.CustomPostEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BulletinBoardService {
    private PostDao postDao;

    public BulletinBoardService(PostDao postDao, AccountDao accountDao) {
        this.postDao = postDao;
    }

    // 掲示板一覧取得メソッド
    public List<CustomPostEntity> getPostList(String searchWord) {
        return postDao.getPostList(searchWord);
    }

    public int createPost(int accountId, String content) {
        return postDao.insert(accountId, content);
    }


}
