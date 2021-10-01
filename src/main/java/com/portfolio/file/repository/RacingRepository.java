package com.portfolio.file.repository;
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
    @Query("SELECT r FROM RacingModel r WHERE r.id = :id")
    RacingModel getOneData(@Param("id")Integer id);
    @Query("SELECT r FROM RacingModel r WHERE r.username = :username")
    List<RacingModel> findByUsername(@Param("username")String username);
    @Query("SELECT r FROM RacingModel r WHERE r.username = :username ORDER BY r.id, r.date asc, r.racing_name, r.racing_place, r.expenditure, r.income_amount")
    List<RacingModel> findAllOrderByAllInfos(@Param("username")String username);
}
