package com.portfolio.file.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

//userテーブルのEntityクラス

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserModel {
    /**
     * ユーザー名. プライマリーキー.
     */
    @Id
    @Column(name = "username", length = 30, nullable = false)
    private String username;

    /** パスワード. */
    @Column(name = "password", length = 255, nullable = false)
    private String password;
}