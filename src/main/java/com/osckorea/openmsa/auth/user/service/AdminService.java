package com.osckorea.openmsa.auth.user.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.osckorea.openmsa.auth.user.domain.User;
import com.osckorea.openmsa.auth.user.domain.UserRepository;
import com.osckorea.openmsa.global.exception.Exception404;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final UserRepository userRepository;

    public void findById(UUID id){
        User account = userRepository.findById(id).orElseThrow(()->new Exception404("존재하지 않는 계정입니다."));
    }
}
