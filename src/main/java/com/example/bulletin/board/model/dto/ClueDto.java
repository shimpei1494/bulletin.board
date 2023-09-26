package com.example.bulletin.board.model.dto;

import lombok.Data;

@Data
public class ClueDto {
    private String clueName;
    private int clueNum;
    private String clueRole;
    private String clueSpecialMove;

    public ClueDto(String clueName, int clueNum, String clueRole, String clueSpecialMove) {
        this.clueName = clueName;
        this.clueNum = clueNum;
        this.clueRole = clueRole;
        this.clueSpecialMove = clueSpecialMove;
    }
}
