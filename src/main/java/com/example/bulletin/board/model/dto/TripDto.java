package com.example.bulletin.board.model.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TripDto {
    private String destination;

    private Integer price;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date departureDate;

}
