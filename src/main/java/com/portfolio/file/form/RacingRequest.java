package com.portfolio.file.form;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RacingRequest implements Serializable {
    /** シリアルバージョンUID. */
    private static final long serialVersionUID = 1L;

//  日付
//  @NotEmpty(message = "日付を入力してください")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

//  レース名
    @NotEmpty(message = "レース名を入力してください")
    @Size(max = 100, message = "レース名は100文字以内で入力してください")
    private String racing_name;

//  レース場
    @NotEmpty(message = "レース場を入力してください")
    @Size(max = 30, message = "レース場は30文字以内で入力してください")
    private String racing_place;

//  支出額
    @NotNull(message = "支出額を入力してください")
    @Digits(integer = 30, fraction = 0, message = "支出額は30桁以内で入力してください")
    private Integer expenditure;

//  収入額
    @NotNull(message = "支出額を入力してください")
    @Digits(integer = 30, fraction = 0, message = "支出額は30桁以内で入力してください")
    private Integer income_amount;

    @NotEmpty
    private String username;


}
