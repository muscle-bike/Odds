package com.portfolio.file.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.portfolio.file.model.RacingModel;

/**
 * Racing(Entity)クラスのリポジトリクラス.
 */
@Repository
public interface RacingRepository extends JpaRepository<RacingModel, Integer> {
    @Query("SELECT r FROM RacingModel r WHERE r.id = :id")
    RacingModel getOneData(@Param("id")Integer id);
}
