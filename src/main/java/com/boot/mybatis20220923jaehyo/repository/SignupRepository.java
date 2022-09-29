package com.boot.mybatis20220923jaehyo.repository;

import com.boot.mybatis20220923jaehyo.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SignupRepository {
    public int save(User user);
}
