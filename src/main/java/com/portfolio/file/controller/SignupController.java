package com.portfolio.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.portfolio.file.form.UserRequest;
import com.portfolio.file.service.UserService;

@Controller
//@RequestMapping("/user")
public class SignupController {
    /** ユーザー登録画面を表示 */
    @GetMapping(value = "/user/signup")
    public String displaySignup(Model model) {
        model.addAttribute("userRequest", new UserRequest());
        // ユーザー登録画面に遷移
        return "user/signup";
    }

    /**
     * ユーザー情報 Service
     */
    @Autowired
    private UserService userService;

//    ユーザークリエイト
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/signup";
        }
//    ユーザー情報の登録
          userService.create(userRequest);
          return "redirect:/login";
    }
}
