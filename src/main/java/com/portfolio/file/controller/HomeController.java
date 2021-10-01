package com.portfolio.file.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.portfolio.file.model.RacingModel;
import com.portfolio.file.model.impl.UserDetailsImpl;
import com.portfolio.file.repository.RacingRepository;
import com.portfolio.file.service.RacingService;
@Controller
public class HomeController {
    @Autowired
    private RacingService racingService;
    private RacingRepository racingRepository;

 // Getメソッド
    @GetMapping("/home")
    public String getHome(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // ログインユーザーの詳細情報を判定
        if (userDetails == null) {
            // ログインユーザーの詳細情報がNULLの場合
            model.addAttribute("loginUsername", "");
        } else {
            // ログインユーザーの詳細情報がNULL以外の場合
            String loginUser = userDetails.getUsername();
//            List<RacingModel> races = racingService.findByUsername(loginUser);
//            model.addAttribute("loginUsername", loginUser);
            List<RacingModel> infos = racingRepository.findAllOrderByAllInfos(loginUser);
            model.addAttribute("infos", infos);
        }
        //  login.htmlに遷移
        return "home/home";
    }
}