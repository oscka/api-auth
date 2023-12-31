package com.osckorea.openmsa.global.exception;


import org.springframework.http.HttpStatus;

import com.osckorea.openmsa.global.api.ApiResponseDto;

import lombok.Getter;

// 권한 없음
@Getter
public class Exception403 extends RuntimeException {
    public Exception403(String message) {
        super(message);
    }

    public ApiResponseDto<?> body(){
        return new ApiResponseDto<>(HttpStatus.FORBIDDEN, "forbidden", getMessage());
    }

    public HttpStatus status(){
        return HttpStatus.FORBIDDEN;
    }
}
