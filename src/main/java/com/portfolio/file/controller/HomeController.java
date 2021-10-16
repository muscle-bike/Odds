package com.portfolio.file.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.portfolio.file.form.DateRequest;
import com.portfolio.file.model.RacingModel;
import com.portfolio.file.model.impl.UserDetailsImpl;
import com.portfolio.file.repository.RacingRepository;
import com.portfolio.file.repository.RacingRepository.RateAllsum;

@Controller
public class HomeController {
    @Autowired
    private RacingRepository racingRepository;

    @GetMapping("/home")
    public String getHome(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails,
            @ModelAttribute DateRequest dateRequest) {
        // ログインユーザーの詳細情報を判定
        if (userDetails == null) {
            // ログインユーザーの詳細情報がNULLの場合
            model.addAttribute("loginUsername", "");
        } else {
            // ログインユーザーの詳細情報がNULL以外の場合
            String loginUser = userDetails.getUsername();
            model.addAttribute("loginUsername", loginUser);
            List<RacingModel> infos = racingRepository.findAllOrderByAllInfos(loginUser);
            model.addAttribute("infos", infos);
        }
        dateRequest.setTAB01("TAB01");
        return "home/home";
    }

    // 日別でのレース情報&月毎とのレース情報取得
    @GetMapping(value = "/date")
    public String racingdate(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails,
            @ModelAttribute DateRequest dateRequest,
            @RequestParam(defaultValue = "NOT PARAM") String requestMonth) {
        String[] requestMonths = requestMonth.split("-");
        int[] yearMonth = Stream.of(requestMonths).mapToInt(Integer::parseInt).toArray();

        String loginUser = userDetails.getUsername();

        // 月初
        Calendar stertdate1 = Calendar.getInstance();
        stertdate1.set(Calendar.YEAR, yearMonth[0]);
        stertdate1.set(Calendar.MONTH, yearMonth[1] - 1);
        stertdate1.set(Calendar.DATE, 1 - 1);
        Date stertdate = new Date();
        stertdate = stertdate1.getTime();

        // 月末
        Calendar enddate1 = Calendar.getInstance();
        enddate1.set(Calendar.YEAR, yearMonth[0]);
        enddate1.set(Calendar.MONTH, yearMonth[1] - 1);
        int endOfManth = enddate1.getActualMaximum(Calendar.DAY_OF_MONTH);
        enddate1.set(Calendar.DATE, endOfManth);
        Date enddate = new Date();
        enddate = enddate1.getTime();

        model.addAttribute("loginUsername", loginUser);

        List<RacingModel> infos = racingRepository.findAllOrderByAllDate(loginUser, stertdate, enddate);
        model.addAttribute("infos", infos);
        dateRequest.setTAB01("TAB01");
        return "home/home";
    }

    // 月間の合計
    @GetMapping("/month")
    public String racingmonth(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails,
            @ModelAttribute DateRequest dateRequest,
            @RequestParam(defaultValue = "NOT PARAM") String requestMonth) {
        String[] requestMonths = requestMonth.split("-");
        int[] yearMonth = Stream.of(requestMonths).mapToInt(Integer::parseInt).toArray();

        String loginUser = userDetails.getUsername();

        // 月初
        Calendar stertdate1 = Calendar.getInstance();
        stertdate1.set(Calendar.YEAR, yearMonth[0]);
        stertdate1.set(Calendar.MONTH, yearMonth[1] - 1);
        stertdate1.set(Calendar.DATE, 1 - 1);
        Date stertdate = new Date();
        stertdate = stertdate1.getTime();

        // 月末
        Calendar enddate1 = Calendar.getInstance();
        enddate1.set(Calendar.YEAR, yearMonth[0]);
        enddate1.set(Calendar.MONTH, yearMonth[1] - 1);
        int endOfManth = enddate1.getActualMaximum(Calendar.DAY_OF_MONTH);
        enddate1.set(Calendar.DATE, endOfManth);
        Date enddate = new Date();
        enddate = enddate1.getTime();

        model.addAttribute("loginUsername", loginUser);
        List<RateAllsum> monthinfos = racingRepository.findAllOrderByAllsum(loginUser, stertdate, enddate);
        RateAllsum rateAllsum = monthinfos.get(0);
        rateAllsum.getCnt();
        rateAllsum.getExsum();
        rateAllsum.getIncomesum();
        model.addAttribute("monthinfos", monthinfos);
        dateRequest.setTAB01("TAB02");
        return "home/home";
    }

    // 年間の合計
    @GetMapping("/year")
    public String racingyear(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails,
            @ModelAttribute DateRequest dateRequest,
            @RequestParam(defaultValue = "NOT PARAM") String requestMonth) {
        String[] requestMonths = requestMonth.split("-");
        int[] yearMonth = Stream.of(requestMonths).mapToInt(Integer::parseInt).toArray();

        String loginUser = userDetails.getUsername();

        //年始
        Calendar stertdate1 = Calendar.getInstance();
        stertdate1.set(Calendar.YEAR, yearMonth[0]);
        stertdate1.set(Calendar.MONTH, 1 - 1);
        stertdate1.set(Calendar.DATE, 1 - 1);
        Date stertdate = new Date();
        stertdate = stertdate1.getTime();
        //年末
        Calendar enddate1 = Calendar.getInstance();
        enddate1.set(Calendar.YEAR, yearMonth[0]);
        enddate1.set(Calendar.MONTH, 12 - 1);
        int endOfManth = enddate1.getActualMaximum(Calendar.DAY_OF_MONTH);
        enddate1.set(Calendar.DATE, endOfManth);
        Date enddate = new Date();
        enddate = enddate1.getTime();

        model.addAttribute("loginUsername", loginUser);
        List<RateAllsum> yearinfos = racingRepository.findAllOrderByAllsum(loginUser, stertdate, enddate);
        RateAllsum rateAllsum = yearinfos.get(0);
        rateAllsum.getCnt();
        rateAllsum.getExsum();
        rateAllsum.getIncomesum();
        model.addAttribute("yearinfos", yearinfos);
        dateRequest.setTAB01("TAB03");
        return "home/home";
    }
}
