package com.portfolio.file.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class DateRequest implements Serializable {
    /** シリアルバージョンUID. */
    private static final long serialVersionUID = 1L;

    private String TAB01;

    @NotEmpty(message = "値を入力してください。")
    private String RequestCalendar;
}