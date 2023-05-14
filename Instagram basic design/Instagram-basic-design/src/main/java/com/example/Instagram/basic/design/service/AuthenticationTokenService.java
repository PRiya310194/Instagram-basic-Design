package com.example.Instagram.basic.design.service;

import com.example.Instagram.basic.design.dao.TokenRepository;
import com.example.Instagram.basic.design.model.AuthenticationToken;
import com.example.Instagram.basic.design.model.InstagramUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationTokenService {
    @Autowired
    TokenRepository tokenRepository;

    public void saveToken(AuthenticationToken token) {
        tokenRepository.save(token);
    }


    public AuthenticationToken getToken(InstagramUser instagramUser) {
        return tokenRepository.findByInstagramUser(instagramUser);
    }
}
