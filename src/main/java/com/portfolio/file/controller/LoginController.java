package com.portfolio.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    /**
     * Redirect用HOME画面パス.
     */
    private final String REDIRECT_HOME_URL = "redirect:/home";

    // Getメソッド
    @GetMapping("/login")
    public String getLogin(Model model) {
        //  login.htmlに遷移
        return "login/login";
    }

    /**
     * ログインに成功した時の処理.
     *
     * @return 遷移先
     */
    @PostMapping("success")
    public String loginSuccess() {
        // HOME画面に遷移する
        return REDIRECT_HOME_URL;
    }
}
