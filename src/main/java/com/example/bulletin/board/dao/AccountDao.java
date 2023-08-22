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


}
