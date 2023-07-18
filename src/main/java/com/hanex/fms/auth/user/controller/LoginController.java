package com.hanex.fms.auth.user.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hanex.fms.auth.user.dto.UserDto;
import com.hanex.fms.auth.user.service.LoginService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/security")
@RequiredArgsConstructor
public class LoginController {


    private final LoginService loginService;

    @Operation(description = "토큰 생성 테스트")
    @PostMapping("/jwtlogin")
    @Transactional
    public ResponseEntity<Map<String, String>> jwtLogin (@Valid  @RequestBody UserDto.LoginRequest loginRequest, HttpServletResponse response) {
        return ResponseEntity.ok(loginService.jwtLogin(loginRequest,response));
    }
}

