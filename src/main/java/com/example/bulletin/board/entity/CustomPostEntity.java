package com.example.bulletin.board.entity;

import lombok.Data;

@Data
public class CustomPostEntity {
    private String content;

    private String postAccountId;

    private String postAccountName;
}
