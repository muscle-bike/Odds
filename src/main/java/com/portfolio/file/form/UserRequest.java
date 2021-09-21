package com.portfolio.file.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
    /**
     * ユーザー情報 リクエストデータ
     */
    @Data
    public class UserRequest implements Serializable {
      /** シリアルバージョンUID. */
      private static final long serialVersionUID = 1L;
      /**
       * 名前
       */
      @NotEmpty(message = "名前を入力してください")
      @Size(max = 100, message = "名前は100桁以内で入力してください")
      private String name;
      /**
       * パスワード
       */
      @NotEmpty(message = "パスワードを入力してください")
      @Size(max = 18, message = "パスワードは18桁以内で入力してください")
      private String password;
    }

