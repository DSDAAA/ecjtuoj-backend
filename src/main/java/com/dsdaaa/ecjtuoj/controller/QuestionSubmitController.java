package com.dsdaaa.ecjtuoj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dsdaaa.ecjtuoj.common.BaseResponse;
import com.dsdaaa.ecjtuoj.common.ErrorCode;
import com.dsdaaa.ecjtuoj.common.ResultUtils;
import com.dsdaaa.ecjtuoj.exception.BusinessException;
import com.dsdaaa.ecjtuoj.exception.ThrowUtils;
import com.dsdaaa.ecjtuoj.model.dto.question.QuestionQueryRequest;
import com.dsdaaa.ecjtuoj.model.dto.questionsubbmit.QuestionSubmitAddRequest;
import com.dsdaaa.ecjtuoj.model.dto.questionsubbmit.QuestionSubmitQueryRequest;
import com.dsdaaa.ecjtuoj.model.entity.Question;
import com.dsdaaa.ecjtuoj.model.entity.QuestionSubmit;
import com.dsdaaa.ecjtuoj.model.entity.User;
import com.dsdaaa.ecjtuoj.model.vo.QuestionSubmitVO;
import com.dsdaaa.ecjtuoj.model.vo.QuestionVO;
import com.dsdaaa.ecjtuoj.service.QuestionSubmitService;
import com.dsdaaa.ecjtuoj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 *
 * @author dsdaaa
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return resultNum 本次点赞变化数
     */

    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
                                               HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }

    /**
     * 分页获取题目提交列表
     *
     * @param questionSubmitQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/list/page/vo")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
                                                                         HttpServletRequest request) {
        long current = questionSubmitQueryRequest.getCurrent();
        long size = questionSubmitQueryRequest.getPageSize();
        //todo 脱敏
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));

        final User loginUser = userService.getLoginUser(request);
        //返回脱敏信息
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUser));
    }

}
