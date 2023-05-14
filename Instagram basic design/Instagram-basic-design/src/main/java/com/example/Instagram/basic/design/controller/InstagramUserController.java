package com.example.Instagram.basic.design.controller;

import com.example.Instagram.basic.design.dto.SignInInput;
import com.example.Instagram.basic.design.dto.SignInOutput;
import com.example.Instagram.basic.design.dto.SignUpInput;
import com.example.Instagram.basic.design.dto.SignUpOutput;
import com.example.Instagram.basic.design.service.InstagramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insUser")
public class InstagramUserController {
    @Autowired
    InstagramUserService insUserService;
    @PostMapping("/signup")
    public SignUpOutput signup(@RequestBody SignUpInput signUpDto){
return insUserService.signUp(signUpDto);
    }
    @PostMapping("/signin")
    public SignInOutput signIn(@RequestBody SignInInput signInDto){
        return insUserService.signIn(signInDto);
    }

}



