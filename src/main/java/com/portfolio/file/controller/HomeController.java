package com.portfolio.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.portfolio.file.model.impl.UserDetailsImpl;
//import com.portfolio.file.service.RacingService;
@Controller
public class HomeController {
    @Autowired
//    private RacingService racingService;

    // Getメソッド
    @GetMapping("/home")
    public String getHome(Model model) {
        //  login.htmlに遷移
        return "home/home";
    }
    /**
     * HOME画面パス.
     */
    private final String HOME_TEMPLATE_PATH = "/home/home";

    /**
     * HOME画面URL.
     */
    private final String HOME_URL = "/home";
    /**
     * Redirect用HOME画面パス.
     */
    private final String REDIRECT_HOME_URL = "redirect:/home";

    /**
     * サイトのドメインにアクセスした時の処理. HOME画面にリダイレクト.
     *
     * @return 遷移先(HOME画面)
     */
    @GetMapping("")
    public String index() {
        // HOME画面に遷移する
        return REDIRECT_HOME_URL;
    }

/**
 * HOME画面表示.
 *
 * @param model       Modelクラス
 * @param userDetails ログインユーザーの詳細情報
 * @return 遷移先
 */

@GetMapping("home/home")
public String index(@PathVariable String username, Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("url", HOME_URL);

    // ログインユーザーの詳細情報を判定
    if (userDetails == null) {
        // ログインユーザーの詳細情報がNULLの場合
        model.addAttribute("loginUsername", "");
    } else {
        // ログインユーザーの詳細情報がNULL以外の場合
        model.addAttribute("loginUsername", userDetails.getUsername());
//        String loginUser = userDetails.getUsername();
        //ユーザー情報の登録
//          racingService.view(loginUser);

//        RacingModel racing_infos = racingService.search();
    }
    return HOME_TEMPLATE_PATH;
}






}
