package com.portfolio.file.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.portfolio.file.dto.RacingRequest;
import com.portfolio.file.service.RacingService;

@Controller
public class RacingController {
//  Getメソッド
   @GetMapping(value ="/new/race")
   public String displayRace(Model model) {
       model.addAttribute("racingRequest", new RacingRequest());
//     レース情報登録画面に遷移
       return "new/race";
   }

//   レース情報 Service

   @Autowired
   private RacingService racingService;

//   レース情報クリエイト
   @RequestMapping(value = "/racing_infos/create", method = RequestMethod.POST)
   public String create(@Validated @ModelAttribute RacingRequest racingRequest, BindingResult result, Model model) {
       if (result.hasErrors()) {
           // 入力チェックエラーの場合
           List<String> errorList = new ArrayList<String>();
           for (ObjectError error : result.getAllErrors()) {
             errorList.add(error.getDefaultMessage());
           }
           model.addAttribute("validationError", errorList);
           return "new/race";
         }
//          ユーザー情報の登録
         racingService.create(racingRequest);
         return "redirect:/home";
   }
 }


