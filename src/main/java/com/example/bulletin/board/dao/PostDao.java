package com.example.bulletin.board.dao;

import com.example.bulletin.board.entity.gen.Post;
import com.example.bulletin.board.entity.gen.PostKey;
import com.example.bulletin.board.mapper.gen.PostMapper;
import org.springframework.stereotype.Component;

@Component
public class PostDao {
    private final PostMapper postMapper;

    public PostDao(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    public Post selectPk(int id) {
        PostKey key = new PostKey();
        key.setId(id);
        return postMapper.selectByPrimaryKey(key);
    }

    public int create(String content) {
        Post entity = new Post();
        entity.setContent(content);
        entity.setPostUserId(3);
        // mappperのinsertメソッドを使うとidやcreated_atなどがnullでエラーが出る
        return postMapper.insertSelective(entity);
    }

}
