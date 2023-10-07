package com.dsdaaa.ecjtuoj.model.dto.question;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 创建请求
 *
 * @author dsdaaa
 *
 */
@Data
public class QuestionAddRequest implements Serializable {

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表（json 数组）
     */
    private List<String> tags;

    /**
     * 题目答案
     */
    private String answer;

    /**
     * 判题用例(JSON数组)
     */
    private List<String> judgeCase;

    /**
     * json对象
     */
    private JudegConfig judgeConfig;

    private static final long serialVersionUID = 1L;
}
