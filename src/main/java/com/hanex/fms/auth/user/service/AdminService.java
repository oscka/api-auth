package com.hanex.fms.auth.user.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hanex.fms.auth.user.domain.User;
import com.hanex.fms.auth.user.domain.UserRepository;
import com.hanex.fms.global.exception.Exception404;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final UserRepository userRepository;

    public void findById(UUID id){
        User account = userRepository.findById(id).orElseThrow(()->new Exception404("존재하지 않는 계정입니다."));
    }
}
