package com.portfolio.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.portfolio.file.dto.RacingRequest;

@Controller
public class RacingController {
//  Getメソッド
   @GetMapping("new/race")
   public String getRace(Model model) {
       model.addAttribute("racingRequest", new RacingRequest());
//     login.htmlに遷移
       return "new/race";
   }

// Postメソッド
   @PostMapping("/new")
   public String postRace(Model model) {
       return "new/race";
   }
}
