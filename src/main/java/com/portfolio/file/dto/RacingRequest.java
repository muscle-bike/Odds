package com.portfolio.file.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class RacingRequest implements Serializable {
//  日付
    @NotEmpty(message = "日付を入力してください")
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
    @NotEmpty(message = "支出額を入力してください")
    @Size(max = 30, message = "支出額は30桁以内で入力してください")
    private String expenditure;

//  収入額
    @NotEmpty(message = "収入額を入力してください")
    @Size(max = 30, message = "収入額は30桁以内で入力してください")
    private String Income_amount;


}
