package com.portfolio.file.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.portfolio.file.model.RacingModel;

/**
 * Racing(Entity)クラスのリポジトリクラス.
 */
@Repository
public interface RacingRepository extends JpaRepository<RacingModel, Integer>{
//  id取得
    @Query("SELECT r FROM RacingModel r WHERE r.id = :id")
    RacingModel getOneData(@Param("id")Integer id);
//  ログインユーザー取得
    @Query("SELECT r FROM RacingModel r WHERE r.username = :username")
    List<RacingModel> findByUsername(@Param("username")String username);
//  ログインユーザーで登録しているレース情報取得
    @Query("SELECT r FROM RacingModel r WHERE r.username = :username ORDER BY r.id, r.date asc, r.racing_name, r.racing_place, r.expenditure, r.income_amount")
    List<RacingModel> findAllOrderByAllInfos(@Param("username")String username);
//  特定の月内で登録したレース情報取得
    @Query("SELECT r FROM RacingModel r WHERE r.username = :username AND :startdate <= r.date AND :enddate >= r.date ORDER BY r.id, r.date asc, r.racing_name, r.racing_place, r.expenditure, r.income_amount")
    List<RacingModel>findAllOrderByAllDate(@Param("username")String username, @Param("startdate")Date startdate, @Param("enddate")Date enddate);
}
