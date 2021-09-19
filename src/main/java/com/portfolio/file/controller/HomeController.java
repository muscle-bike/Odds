package com.portfolio.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
//  Getメソッド
   @GetMapping("/home")
   public String getLogin(Model model) {
//     login.htmlに遷移
       return "home/home";
   }

// Postメソッド
   @PostMapping("/home")
   public String postLogin(Model model) {
       return "home/home";
   }
}
