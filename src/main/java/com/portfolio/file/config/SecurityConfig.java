package com.portfolio.file.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.portfolio.file.service.impl.UserDetailsServiceImpl;

/**
 * 認証・認可を設定するクラス.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * ユーザー情報Serviceクラス(実装クラス).
     */
    @Autowired
    UserDetailsServiceImpl service;

    /**
     * パスワードの暗号化クラスを返却する.
     *
     * @return BCryptPasswordEncoder
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 認証を除外する対象を設定する.
     *
     * @param web WebSecurity
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // spring securityで無視するリクエストパスを設定
        // 静的ファイルを除外する
        web.ignoring().antMatchers("/css/**", "/webjars/**");

    }

    /**
     * 認証方法を設定する.
     *
     * @param auth AuthenticationManagerBuilder
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 拡張してDB認証を実行する
        auth.userDetailsService(service);
    }

    /**
     * 認証対象やログイン・ログアウト処理を設定する.
     *
     * @param http HttpSecurity
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ログイン処理の認証ルールを設定
        http.authorizeRequests()
                // TODO 開発中のみ有効にする
                .antMatchers("/**").permitAll()
                // TODO 開発が終わったら、認証を有効にする
                // .antMatchers("/file", "/file/login").permitAll() // 認証なしでアクセス可能なパス
                // .antMatchers("/file/user_master/**").hasAuthority("ADMIN") //
                // ADMINロールを持つユーザーのみアクセス許可
                // .antMatchers("/file/user_master/**").hasAuthority("ADMIN") //
                // ADMINロールを持つユーザーのみアクセス許可
                .anyRequest().authenticated() // それ以外は認証が必要
                .and().sessionManagement().sessionFixation().none().and().formLogin().loginPage("/login")
                .loginProcessingUrl("/login") // ログインフォームのアクションに指定したURL[action="@{/login}"]を設定
                .usernameParameter("username") // ログインフォームのユーザー欄のname属性を設定
                .passwordParameter("password") // ログインフォームのパスワード欄のname属性を設定
                .successForwardUrl("/success") // ログイン成功時に遷移するURL
                .failureUrl("/login?error") // ログイン失敗時に遷移するURL
                .permitAll().and().logout().logoutUrl("/logout").permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

}
