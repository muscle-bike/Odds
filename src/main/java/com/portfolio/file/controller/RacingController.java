package com.portfolio.file.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.portfolio.file.form.RacingRequest;
import com.portfolio.file.form.RacingUpdateRequest;
import com.portfolio.file.model.RacingModel;
import com.portfolio.file.model.impl.UserDetailsImpl;
import com.portfolio.file.service.RacingService;

@Controller
public class RacingController {
    //レース情報 Service
    @Autowired
    private RacingService racingService;
    //Getメソッド
    //レース情報新規登録画面表示
   @GetMapping(value ="/new/race")
   public String displayRace(Model model) {
       model.addAttribute("racingRequest", new RacingRequest());
       //レース情報登録画面に遷移
       return "new/race";
   }

   //レース情報編集画面を表示
   @GetMapping(value ="/edit/edit/{id}")
       public String displayEdit(@PathVariable Integer id, Model model) {
           RacingModel racing_infos = racingService.findById(id);
           RacingUpdateRequest racingUpdateRequest = new RacingUpdateRequest();
           racingUpdateRequest.setId(racing_infos.getId());
           racingUpdateRequest.setDate(racing_infos.getDate());
           racingUpdateRequest.setRacing_name(racing_infos.getRacing_name());
           racingUpdateRequest.setRacing_place(racing_infos.getRacing_place());
           racingUpdateRequest.setExpenditure(racing_infos.getExpenditure());
           racingUpdateRequest.setIncome_amount(racing_infos.getIncome_amount());
           model.addAttribute("RacingUpdateRequest", racingUpdateRequest);
       return "edit/edit";
   }

   RacingModel racingmodel = new RacingModel();
   //レース情報クリエイト
   @RequestMapping(value = "/racing_infos/create", method = RequestMethod.POST)

   public String create(@Validated @ModelAttribute RacingRequest racingRequest, BindingResult result, Model model,
           @AuthenticationPrincipal UserDetailsImpl userDetails) {
       if (result.hasErrors()) {
           return "new/race";
         }

       String loginUser = userDetails.getUsername();
       //ユーザー情報の登録
         racingService.create(racingRequest, loginUser);
         return "redirect:/home";
   }

   //レース情報の更新
   @RequestMapping(value = "/racing_infos/update", method = RequestMethod.POST)
   public String update(@Validated @ModelAttribute RacingUpdateRequest racingUpdateRequest, BindingResult result, Model model) {
     if (result.hasErrors()) {
       return "edit/edit";
     }
     // ユーザー情報の更新
     racingService.update(racingUpdateRequest);
     return String.format("redirect:/racing_infos/%d", racingUpdateRequest.getId());
   }

   //レース情報削除（idを削除する）
   @GetMapping("/racing_infos/delete/{id}")
   public String delete(@PathVariable Integer id, Model model) {
     // ユーザー情報の削除
     racingService.delete(id);
     return "redirect:/home";
   }
 }