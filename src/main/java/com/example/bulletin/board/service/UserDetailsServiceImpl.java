package com.example.bulletin.board.service;

import com.example.bulletin.board.dao.AccountDao;
import com.example.bulletin.board.entity.gen.Account;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AccountDao accountDao;

    public UserDetailsServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountDao.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return User.withUsername(account.getName())
                .password(account.getPassword())
                // 役割が設定
//                .roles("USER")
                // 無効なアカウントはログインさせない(enabledがfalseの場合、無効)
//                .disabled(!account.getEnabled())
                // アカウントが有効期限が今日より過去の場合はtrueにして期限切れにする
//                .accountExpired()
                // パスワードの有効期限切れ
//                .credentialsExpired()
                // ログイン失敗回数~回以上でロック
//                .accountLocked()
                .build();
    }
}
