package com.example.bulletin.board.dao;

import com.example.bulletin.board.entity.CustomPostEntity;
import com.example.bulletin.board.entity.CustomPostExample;
import com.example.bulletin.board.entity.gen.Post;
import com.example.bulletin.board.entity.gen.PostKey;
import com.example.bulletin.board.mapper.CustomPostMapper;
import com.example.bulletin.board.mapper.gen.PostMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostDao {
    private final PostMapper postMapper;
    private final CustomPostMapper customPostMapper;

    public PostDao(PostMapper postMapper,
                   CustomPostMapper customPostMapper) {
        this.postMapper = postMapper;
        this.customPostMapper = customPostMapper;
    }

    public Post selectPk(int id) {
        PostKey key = new PostKey();
        key.setId(id);
        return postMapper.selectByPrimaryKey(key);
    }

    public int create(String content) {
        Post entity = new Post();
        entity.setContent(content);
//        entity.setPostUserId(3);
        // mappperのinsertメソッドを使うとidやcreated_atなどがnullでエラーが出る
        return postMapper.insertSelective(entity);
    }

    public int insert(int accountId, String content) {
        Post entity = new Post();
        entity.setPostAccountId(accountId);
        entity.setContent(content);
        // mappperのinsertメソッドを使うとidやcreated_atなどがnullでエラーが出る
        return postMapper.insertSelective(entity);
    }

    public List<CustomPostEntity> getPostList(String searchWord) {
        // example（条件）を作成する
        final CustomPostExample example = new CustomPostExample();
        example.setSearchWord(searchWord);

        return customPostMapper.selectPostList(example);
    }

}
