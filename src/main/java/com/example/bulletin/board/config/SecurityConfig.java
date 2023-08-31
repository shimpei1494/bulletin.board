package com.example.bulletin.board.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

//    @Autowired
//    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                      静的ファイルを認証なしで確認するために以下の3行を書いていたが、上の1行だけで済むみたい
//                        .requestMatchers("/css/**").permitAll()
//                        .requestMatchers("/js/**").permitAll()
//                        .requestMatchers("/webjars/**").permitAll()
                    .requestMatchers("/login", "/").permitAll()
                            .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                    // 上と下のhasAuthorityとhasRoleは同じ意味で権限チェックができる→権限ない場合は403エラー
//                                .requestMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
            )
            .formLogin((form) -> form
                    // ログインページへのパスを指定→コントローラーにもGET、/loginでの処理を記載する必要がある
                    .loginPage("/login")
                    // ログイン成功時に表示される画面へのパス
                    .defaultSuccessUrl("/")
                    .permitAll()
            )
            .logout((logout) -> logout.permitAll());

        return http.build();
    }

    /**
    以下は参考
     */

//    @Bean
//    public UserDetailsManager userDetailsManager() {
//        JdbcUserDetailsManager user = new JdbcUserDetailsManager(this.dataSource);
//        // ユーザーを追加したい時
////        user.createUser(makeUser("admin", "pass", "ADMIN"));
//
//        return user;
//    }

//    private UserDetails makeUser(String user, String pass, String role) {
//        return User.withUsername(user)
//                .password(passwordEncoder().encode(pass))
//                .roles(role)
//                .disabled(false)
//                .build();
//    }

    // データベースを使用せずユーザー名user、パス123456という固定でログインするための設定
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User
//                .withUsername("user")
//                .password(passwordEncoder().encode("123456"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }

}
