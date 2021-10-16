package com.portfolio.file.form;

import java.io.Serializable;

import lombok.Data;

@Data
public class DateRequest implements Serializable {
    /** シリアルバージョンUID. */
    private static final long serialVersionUID = 1L;

    private String TAB01;
}