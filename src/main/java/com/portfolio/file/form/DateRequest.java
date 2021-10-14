package com.portfolio.file.form;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@SuppressWarnings("unused")
@Data
public class DateRequest implements Serializable {
    /** シリアルバージョンUID. */
    private static final long serialVersionUID = 1L;

    private String TAB01;
}