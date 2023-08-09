package com.example.bulletin.board.dao;

import com.example.bulletin.board.entity.gen.Post;
import com.example.bulletin.board.entity.gen.PostExample;
import com.example.bulletin.board.entity.gen.PostKey;
import com.example.bulletin.board.mapper.gen.PostMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class PostDao {
    private final PostMapper postMapper;

    public PostDao(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    public Post selectPk(int id) {
        // 以下不要だった
//        PostExample example = new PostExample();
//        PostExample.Criteria criteria = example.createCriteria();
//        criteria.andIdEqualTo(id);
        PostKey key = new PostKey();
        key.setId(id);
        return postMapper.selectByPrimaryKey(key);
    }

}
