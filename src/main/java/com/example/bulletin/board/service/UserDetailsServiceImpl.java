package com.example.bulletin.board.service;

import com.example.bulletin.board.dao.AccountDao;
import com.example.bulletin.board.entity.gen.Account;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AccountDao accountDao;

    //何回以上失敗したらロックするか
    int lockingBoundaries = 3;

    public UserDetailsServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountDao.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return User.withUsername(account.getName())
                .password(account.getPassword())
                // 役割が設定（rolesも引数変わるが権限に使える、権限はStringをカンマ区切りで複数指定できる）
                .authorities(account.getAuthority())
                // 無効なアカウントはログインさせない(del_flgが1の場合、論理削除）
                .disabled("1".equals(account.getDelFlg()))
                // アカウントが有効期限が今日より過去の場合はtrueにして期限切れにする
                .accountExpired(account.getExpiration().before(new Date()))
                // パスワードの有効期限切れ
                .credentialsExpired(account.getPasswordExpiration().before(new Date()))
                // ログイン失敗回数3回以上でロック
                .accountLocked(account.getLoginFailureCount() >= lockingBoundaries)
                .build();
    }

    /**
     * ハンドラは@EventListenerを付与したメソッドがDIコンテナに登録されればOK
     * メソッド名はなんでも良くて、引数にどんなイベントが渡されるかでどの場合に発火するかが決まる
     */

    // ログイン失敗時のハンドラ
    @EventListener
    public void loginFailureHandle(AuthenticationFailureBadCredentialsEvent event) {
        String username = event.getAuthentication().getName();
        accountDao.incrementLoginFailureCount(username);
    }

    // ログイン成功時のハンドラ
    @EventListener
    public void loginSuccessHandle(AuthenticationSuccessEvent event) {
        String username = event.getAuthentication().getName();
        // ログイン失敗回数を0にする
        accountDao.resetLoginFailureCount(username);
    }


}
