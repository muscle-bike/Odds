package com.portfolio.file.controller;

import java.util.Calendar;
import java.util.Date;
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
    @Autowired
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
            model.addAttribute("loginUsername", loginUser);
            List<RacingModel> infos = racingRepository.findAllOrderByAllInfos(loginUser);
            model.addAttribute("infos", infos);
        }
        //  login.htmlに遷移
        return "home/home";
    }

    @GetMapping(value = "/date")
    public String racingdate(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {

        String loginUser = userDetails.getUsername();

        Calendar stertdate1 = Calendar.getInstance();
        stertdate1.set(Calendar.YEAR, 2021);
        stertdate1.set(Calendar.MONTH,  10 - 1);
        stertdate1.set(Calendar.DATE,    1 - 1);
        Date stertdate = new Date();
        stertdate = stertdate1.getTime();

        Calendar enddate1 = Calendar.getInstance();
        enddate1.set(Calendar.YEAR, 2021);
        enddate1.set(Calendar.MONTH,  11 - 1);
        enddate1.set(Calendar.DATE,    1 - 1);
        Date enddate = new Date();
        enddate = enddate1.getTime();

        model.addAttribute("loginUsername", loginUser);

        List<RacingModel> infos = racingRepository.findAllOrderByAllDate(loginUser, stertdate, enddate);
        model.addAttribute("infos", infos);
    return "home/home";
}

//    @GetMapping("/year")
//    public String racingyear(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
//
//        String loginUser = userDetails.getUsername();
//
//        Calendar stertdate1 = Calendar.getInstance();
//        stertdate1.set(Calendar.YEAR,    2021);
//        stertdate1.set(Calendar.MONTH,  1 - 1);
//        stertdate1.set(Calendar.DATE,   1 - 1);
//        Date stertdate = new Date();
//        stertdate = stertdate1.getTime();
//
//        Calendar enddate1 = Calendar.getInstance();
//        enddate1.set(Calendar.YEAR,     2021);
//        enddate1.set(Calendar.MONTH,  12 - 1);
//        enddate1.set(Calendar.DATE,    31 - 1);
//        Date enddate = new Date();
//        enddate = enddate1.getTime();
//
//        model.addAttribute("loginUsername", loginUser);
//
//        List<RacingModel> suminfos = racingRepository.findAllOrderByAllsum(loginUser, stertdate, enddate);
//        model.addAttribute("suminfos", suminfos);
//    return "home/home";
}
