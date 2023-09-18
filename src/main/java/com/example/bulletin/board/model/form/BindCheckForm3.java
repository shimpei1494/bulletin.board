package com.example.bulletin.board.model.form;

import com.example.bulletin.board.model.dto.FoodDto;
import com.example.bulletin.board.model.dto.TripDto;
import lombok.Data;

import java.util.List;

@Data
public class BindCheckForm3 {
    private FoodDto food;
    private TripDto trip;
}