package com.boot.mybatis20220923jaehyo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SignupRespDto {
    private int userCode;
    private String userId;
    private String userPassword;
    private String userName;
    private String userEmail;

}
