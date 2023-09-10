package com.example.bulletin.board.entity;

import lombok.Data;

@Data
public class CustomPostEntity {
    private String content;

    private Integer postId;

    private Integer postAccountId;

    private String postAccountName;
}
