package com.portfolio.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.file.model.UserModel;

/**
 * User(Entity)クラスのリポジトリクラス.
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {
    UserModel findByUsername(String username);

}