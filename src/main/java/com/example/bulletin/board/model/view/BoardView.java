package com.example.bulletin.board.model.view;

import lombok.Data;

import java.util.Date;

@Data
public class BoardView {
    private String userName;
    private String content;
    private Date publishDate;
}
