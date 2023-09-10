package com.example.bulletin.board.logic;

import com.example.bulletin.board.service.AccountService;
import com.example.bulletin.board.service.BulletinBoardService;
import org.springframework.stereotype.Component;

@Component
public class PostCreateLogic {
    private BulletinBoardService bulletinBoardService;

    private AccountService accountService;

    public PostCreateLogic(BulletinBoardService bulletinBoardService, AccountService accountService) {
        this.bulletinBoardService = bulletinBoardService;
        this.accountService = accountService;
    }

    // 新規作成実行ロジックメソッド
    // 成功時：result=1、失敗時：result=0
    public int execute(String content, String accountName) {
        int accountId = accountService.getAccountIdByAccountName(accountName);
        int result = 0;
        if (accountId != -1) {
            result = bulletinBoardService.createPost(accountId, content);
        }
        return result;
    }
}
