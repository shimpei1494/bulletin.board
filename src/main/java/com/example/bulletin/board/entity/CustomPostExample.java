package com.example.bulletin.board.entity;

import lombok.Data;

@Data
public class CustomPostExample {
    private String searchWord;
    private Integer limit;
    private Integer offset;
}
