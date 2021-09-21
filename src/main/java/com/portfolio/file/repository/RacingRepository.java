package com.portfolio.file.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.file.model.RacingModel;

/**
 * Racing(Entity)クラスのリポジトリクラス.
 */
@Repository
public interface RacingRepository extends JpaRepository<RacingModel, Integer> {

}
