package com.dsdaaa.ecjtuoj.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 提交状态枚举
 *
 * @author dsdaaa
 */
public enum QuestionSubmitStatusEnum {

    ACCEPTED("ACCEPTED", "accepted"),
    WRONG("WRONG", "Wrong Answer"),
    COMPILE("COMPILE", "编译错误"),
    MEMORY("MEMORY", "内存溢出"),
    TIME("TIME", "超时"),
    PRESSENTATION("PRESSENTATION", "展示错误"),
    OUTPUT("OUT PUT LIMIT", "输出溢出"),
    WAITING("WAITING", "等待"),
    DANGEROUT("DANGEROUT DPERATION", "危险操作"),
    RUNTIMEERROR("RUNTIME ERROR", "运行错误"),
    SYSTEMERROR("SYSTEM ERROR", "系统错误");
    private final String text;

    private final String value;

    QuestionSubmitStatusEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<String> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value
     * @return
     */
    public static QuestionSubmitStatusEnum getEnumByValue(Integer value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (QuestionSubmitStatusEnum anEnum : QuestionSubmitStatusEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
