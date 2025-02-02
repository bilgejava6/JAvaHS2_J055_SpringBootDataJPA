package com.muhammet.jpa.service;

import com.muhammet.jpa.dto.request.DoRegisterRequestDto;
import com.muhammet.jpa.entity.Auth;
import com.muhammet.jpa.repository.AuthRepository;
import com.muhammet.jpa.utility.RoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository repository;

    public Auth doRegister(DoRegisterRequestDto dto) {
        Auth auth = Auth.builder()
                .userName(dto.userName())
                .password(dto.password())
                .roleType(RoleType.USER)
                .build();
        repository.save(auth);
        return auth;
    }

}
