package com.dsdaaa.ecjtuoj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dsdaaa.ecjtuoj.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户数据库操作
 *
 * @author dsdaaa
 *
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




