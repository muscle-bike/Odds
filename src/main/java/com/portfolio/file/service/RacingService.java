package com.portfolio.file.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.file.dto.RacingRequest;
import com.portfolio.file.model.RacingModel;
import com.portfolio.file.repository.RacingRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class RacingService {
@Autowired
private RacingRepository racingRepository;

//レース情報全検索
public List<RacingModel> seachAll() {
    return racingRepository.findAll();
}

//レース情報登録
public void create(RacingRequest racingRequest) {
    RacingModel racing_infos = new RacingModel();
    racing_infos.setDate(racingRequest.getDate());
    racing_infos.setRacing_name(racingRequest.getRacing_name());
    racing_infos.setRacing_place(racingRequest.getRacing_place());
    racing_infos.setExpenditure(racingRequest.getExpenditure());
    racing_infos.setIncome_amount(racingRequest.getIncome_amount());
    racingRepository.save(racing_infos);
 }
}
