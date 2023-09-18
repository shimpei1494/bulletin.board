package com.example.bulletin.board.model.form;

import lombok.Data;

import java.io.Serializable;

@Data
public class RequestStudyForm implements Serializable {
    private String food;
    private String trip;
    // ゲッターセッターがあれば、コンストラクタはデフォルトコンストラクタで良さそうだった
}
