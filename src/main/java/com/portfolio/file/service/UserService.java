package com.portfolio.file.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.file.form.UserRequest;
import com.portfolio.file.model.UserModel;
import com.portfolio.file.repository.UserRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
  /**
   * ユーザー情報 Repository
   */
  @Autowired
  private UserRepository userRepository;

    /**
     * PasswordEncoderクラス.
     */
    @Autowired
    PasswordEncoder passwordEncoder;
  /**
   * ユーザー情報 全検索
   * @return 検索結果
   */
  public List<UserModel> searchAll() {
    return userRepository.findAll();
  }

  /**
   * ユーザー情報 新規登録
   * @param user ユーザー情報
   */
  public void create(UserRequest userRequest) {
        UserModel user = new UserModel();
        user.setUsername(userRequest.getName());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userRepository.save(user);
  }
}