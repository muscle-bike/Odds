package com.portfolio.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
//  Getメソッド
   @GetMapping("/login")
   public String getLogin(Model model) {
//     login.htmlに遷移
       return "login/login";
   }

// Postメソッド
   @PostMapping("/login")
   public String postLogin(Model model) {
       return "login/login";
   }
}
