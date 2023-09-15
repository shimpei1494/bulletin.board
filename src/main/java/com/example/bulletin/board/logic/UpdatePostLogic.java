package com.example.bulletin.board.logic;

import com.example.bulletin.board.service.BulletinBoardService;
import org.springframework.stereotype.Component;

@Component
public class UpdatePostLogic {
    private BulletinBoardService bulletinBoardService;


    public UpdatePostLogic(BulletinBoardService bulletinBoardService) {
        this.bulletinBoardService = bulletinBoardService;
    }

    // 更新実行ロジックメソッド
    // 成功時：result=1、失敗時：result=0
    public int execute(Integer editPostId, String content) {

        int result = 0;
        result = bulletinBoardService.updatePost(editPostId, content);

        return result;
    }
}
