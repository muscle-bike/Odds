package com.portfolio.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.file.model.UserModel;

/**
 * User(Entity)クラスのリポジトリクラス.
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {
    /**
     * ユーザー名に紐付くUser(Entity)クラスの件数を取得.
     *
     * @param username ユーザー名
     * @return 件数
     */
//    @Query("select count(e) from UserModel e WHERE e.username = :username")
//    long countByUsername(@Param("username") String username);
}