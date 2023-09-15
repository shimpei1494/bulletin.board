package com.example.bulletin.board.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class PagerDto {
    private Integer totalCount;
    private String baseUrl;
    private boolean prev;
    private boolean next;
    private String firstPageUrl;
    private String prevPageUrl;
    private String nextPageUrl;
    private String lastPageUrl;
    private Integer currentPageNumber;
    private List<Integer> showPageList;
}
