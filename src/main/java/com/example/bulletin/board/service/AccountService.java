package com.example.bulletin.board.service;

import com.example.bulletin.board.dao.AccountDao;
import com.example.bulletin.board.entity.gen.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    // アカウント名からPKであるアカウントIDを取得
    public int getAccountIdByAccountName(String accountName) {
        // ユーザー名を基にDBからアカウント情報を取得
        Optional<Account> account = accountDao.findByUserName(accountName);
        // アカウントが存在すればアカウントIDを設定し、存在しなければ-1とする
        return account.map(Account::getId).orElse(-1);
    }
}
