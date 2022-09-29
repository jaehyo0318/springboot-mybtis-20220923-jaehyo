package com.boot.mybatis20220923jaehyo.controller.api;

import com.boot.mybatis20220923jaehyo.domain.User;
import com.boot.mybatis20220923jaehyo.dto.CMRespDto;
import com.boot.mybatis20220923jaehyo.dto.SignupReqDto;
import com.boot.mybatis20220923jaehyo.dto.SignupRespDto;
import com.boot.mybatis20220923jaehyo.repository.SignupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final SignupRepository signupRepository;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(SignupReqDto signupReqDto) {

        log.info("{}", signupReqDto);
        
//        try {
//            throw new RuntimeException("강제로 예외 발생");
//        }catch (Exception e) {
//            return  ResponseEntity.internalServerError()
//                    .body(new CMRespDto<>(-1, "회원가입 실패", user));
//        }

        User user = signupReqDto.toEntity();
        
        log.info("마이바티스 가기전 Entity: {}", user);
        int result = signupRepository.save(user);
        log.info("마이바티스 다녀온 후 Entity: {}", user);

        SignupRespDto signupRespDto = user.toDto();

        if(result == 0) {
            return  ResponseEntity.internalServerError()
                    .body(new CMRespDto<>(-1, "회원가입 실패", signupRespDto));
        }

        return ResponseEntity.ok(new CMRespDto<>(1, "회원가입 성공", signupRespDto));
    }
}
