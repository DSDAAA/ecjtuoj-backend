package com.dsdaaa.ecjtuoj.model.dto.questionsubbmit;

import lombok.Data;

/**
 * 判题信息
 */
@Data
public class JudegInfo {

    /**
     * 程序运行执行信息
     */
    private String message;

    /**
     * 消耗内存
     */
    private Long memorylimit;

    /**
     *消耗时间
     */
    private Long time;
}
