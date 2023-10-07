package com.dsdaaa.ecjtuoj.model.dto.question;

import lombok.Data;

/**
 * 题目配置
 */
@Data
public class JudegConfig {

    /**
     * 时间限制
     */
    private long timelimit;

    /**
     * 内存限制
     */
    private long memorylimit;

    /**
     *堆栈限制
     */
    private long stacklimit;
}
