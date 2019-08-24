package com.jessin.practice.model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author zexin.guo
 * @create 2018-11-06 下午11:05
 **/
@Data
public class Hello {
    private String key;

    private String value;

    private Timestamp birthday;


}
