package com.example.bulletin.board.mapper;

import com.example.bulletin.board.entity.CustomPostEntity;
import com.example.bulletin.board.entity.CustomPostExample;
import lombok.NonNull;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomPostMapper {

    int countByExample(@NonNull @Param("example")CustomPostExample example);

    List<CustomPostEntity> selectPostList(@NonNull @Param("example")CustomPostExample example);
}
