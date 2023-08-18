package com.example.bulletin.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig{

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/js/**").permitAll()
                        .requestMatchers("/webjars/**").permitAll()
                        .requestMatchers("/login", "/").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsManager userDetailsManager() {
        JdbcUserDetailsManager user = new JdbcUserDetailsManager(this.dataSource);
        // ユーザーを追加したい時
//        user.createUser(makeUser("bbb", "pass", "USER"));

        return user;
    }

    private UserDetails makeUser(String user, String pass, String role) {
        return User.withUsername(user)
                .password(passwordEncoder().encode(pass))
                .roles(role)
                .disabled(false)
                .build();
    }

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
