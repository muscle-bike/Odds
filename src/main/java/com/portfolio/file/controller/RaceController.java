package com.portfolio.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RaceController {
//  Getメソッド
   @GetMapping("new/race")
   public String getRace(Model model) {
//     login.htmlに遷移
       return "new/race";
   }

// Postメソッド
   @PostMapping("/new")
   public String postRace(Model model) {
       return "new/race";
   }
}
