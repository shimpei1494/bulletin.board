package com.example.bulletin.board.model.view;

import com.example.bulletin.board.entity.CustomPostEntity;
import com.example.bulletin.board.model.dto.PagerDto;
import lombok.Data;

import java.util.List;

@Data
public class BoardView {
    private List<CustomPostEntity> list;
    private PagerDto pager;
}
