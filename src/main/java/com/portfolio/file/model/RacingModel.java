package com.portfolio.file.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

//racing_infosテーブルのEntityクラス

@Getter
@Setter
@Entity
@Table(name = "racing_infos")
public class RacingModel {
//    id,PK
    @Id
    @Column(name = "id", length = 30, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    日付
    @Column(name = "date", nullable = false)
    private Date date;

//    レース名
    @Column(name = "racing_name", length = 30, nullable = false)
    private String racing_name;

//    レース場
    @Column(name = "racing_place", length = 30, nullable = false)
    private String racing_place;

//    支出額
    @Column(name = "expenditure", length = 30, nullable = false)
    private Integer expenditure;

//    支出額
    @Column(name = "Income_amount", length = 30, nullable = false)
    private Integer Income_amount;
}
