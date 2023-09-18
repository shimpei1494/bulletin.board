package com.example.bulletin.board.model.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class BindCheckForm1 {
    private int id;

    private Integer money;

    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String email;

    private Boolean bool;
}
