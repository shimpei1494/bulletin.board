package com.example.bulletin.board.dao;

import com.example.bulletin.board.entity.gen.Account;
import com.example.bulletin.board.entity.gen.AccountExample;
import com.example.bulletin.board.mapper.gen.AccountMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AccountDao {
    private final AccountMapper accountMapper;

    public AccountDao(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public Optional<Account> findByUserName(String name) {
        AccountExample example = new AccountExample();
        var criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        // usernameがユニークだから、カスタムマッパーでユーザーネームに一致するAccountをリストじゃなくエンティティで取得した方が無駄な処理が減ってスマートになる
        List<Account> list = accountMapper.selectByExample(example);
        Account account = null;
        if (list.size() == 1) {
            account = list.get(0);
        }
        return Optional.ofNullable(account);
    }

    // 失敗カウントをプラス1する
    public void incrementLoginFailureCount(String username) {
        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(username);
        // usernameが一致するデータを取得
        List<Account> accountList = accountMapper.selectByExample(example);
        Account account = null;
        if (accountList.size() == 1) {
            account = accountList.get(0);
        } else {
            return;
        }

        // 失敗カウントをプラス１する
        account.setLoginFailureCount(account.getLoginFailureCount() + 1);

        // データを更新する
        accountMapper.updateByPrimaryKeySelective(account);
    }

    // 失敗カウントを0にする
    public void resetLoginFailureCount(String username) {
        Account account = new Account();
        account.setName(username);

        // 失敗カウントを0にする
        account.setLoginFailureCount(0);

        // データを更新する
        accountMapper.updateByPrimaryKeySelective(account);
    }


}
