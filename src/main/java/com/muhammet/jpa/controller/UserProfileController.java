package com.muhammet.jpa.controller;

import com.muhammet.jpa.entity.UserProfile;
import com.muhammet.jpa.service.UserProfileSerive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-profile")
public class UserProfileController {
    // Constructor Injection
    private final UserProfileSerive userProfileSerive;
    public UserProfileController(UserProfileSerive userProfileSerive){
        this.userProfileSerive = userProfileSerive;
    }

    @GetMapping("/default-create-user")
    public void defaultUserCreate(){
        userProfileSerive.save(UserProfile.builder()
                        .age(36)
                        .email("demet@gmail.com")
                        .name("Demet TAŞ")
                        .password("Aa123456**")
                        .phone("0 555 999 8877")
                        .userName("demet.tas")
                .build());
        userProfileSerive.save(UserProfile.builder()
                .age(56)
                .email("ayse@gmail.com")
                .name("Ayşe YALIN")
                .password("Aa123456**")
                .phone("0 533 659 6655")
                .userName("yln.ayse")
                .build());
        userProfileSerive.save(UserProfile.builder()
                .age(26)
                .email("bengu@gmail.com")
                .name("Bengü GÜNEŞ")
                .password("Aa123456**")
                .phone("0 545 566 9988")
                .userName("gunes_bengu")
                .build());
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<UserProfile>> getAll(){
        List<UserProfile> allProfiles = userProfileSerive.getAll();
        return ResponseEntity.ok(allProfiles);
    }
}
