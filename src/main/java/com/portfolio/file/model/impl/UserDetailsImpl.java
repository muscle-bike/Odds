package com.portfolio.file.model.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.portfolio.file.model.UserModel;

/**
 * ユーザー詳細情報の拡張クラス.
 *
 */
public class UserDetailsImpl implements UserDetails {

    /** シリアルバージョンUID. */
    private static final long serialVersionUID = 1L;

    private static final boolean IS_ENABLED = true;

    /** ユーザーEntityクラス. */
    private UserModel user;

    /** ユーザーの権限情報. */
    private Collection<GrantedAuthority> authorities;

    /**
     * コンストラクタ.
     *
     * @param user        User(Entityクラス)
     * @param authorities ユーザーの権限情報
     */
    public UserDetailsImpl(UserModel user, Collection<GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    /**
     * ユーザーのパスワードを取得する.
     *
     * @return ユーザーのパスワード
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * ユーザー情報が有効か確認する.
     *
     * @return ユーザー情報の有効フラグ
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * ユーザーの権限情報を取得する.
     *
     * @return ユーザーの権限情報
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * ユーザー名を取得する.
     *
     * @return ユーザー名
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * ユーザーアカウントが有効期限内か確認するフラグを取得する. ユーザー情報が有効な場合は、有効期限内とする.
     *
     * @return アカウント有効期限内フラグ
     */
    @Override
    public boolean isAccountNonExpired() {
        return IS_ENABLED;
    }

    /**
     * ユーザーアカウントがロックされているか確認するフラグを取得する. ユーザー情報が無効な場合は、ロックされたとする.
     *
     * @return アカウントロックフラグ
     */
    @Override
    public boolean isAccountNonLocked() {
        return IS_ENABLED;
    }

    @Override
    /**
     * パスワードの有効期限内か確認するフラグを取得する. ユーザー情報が無効な場合は、パスワードの有効期限外とする.
     *
     * @return パスワードの有効期限内フラグ
     */
    public boolean isCredentialsNonExpired() {
        return IS_ENABLED;
    }

}
