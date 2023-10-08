package com.dsdaaa.ecjtuoj.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dsdaaa.ecjtuoj.model.entity.Question;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 13180
* @description 针对表【question(题目)】的数据库操作Mapper
* @createDate 2023-09-19 20:00:18
* @Entity generator.domain.Question
*/
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

}




