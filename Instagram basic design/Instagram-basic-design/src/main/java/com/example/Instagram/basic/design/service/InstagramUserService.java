package com.example.Instagram.basic.design.service;

import com.example.Instagram.basic.design.dao.InstagramUserRepository;
import com.example.Instagram.basic.design.dto.SignInInput;
import com.example.Instagram.basic.design.dto.SignInOutput;
import com.example.Instagram.basic.design.dto.SignUpInput;
import com.example.Instagram.basic.design.dto.SignUpOutput;
import com.example.Instagram.basic.design.model.AuthenticationToken;
import com.example.Instagram.basic.design.model.InstagramUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class InstagramUserService {
    @Autowired
    InstagramUserRepository instagramUserRepository;
    @Autowired
    AuthenticationTokenService authenticationTokenService;

    public SignUpOutput signUp(SignUpInput signUpDto) {
        InstagramUser instagramUser=instagramUserRepository.findFirstByEmail(signUpDto.getUserEmail());
        if(instagramUser!=null){
            throw new IllegalStateException("user already exist !!!....sign in instead");
        }
        String encryptedPassword=null;
        try {
            encryptedPassword=encryptPassword(signUpDto.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // save the user

        instagramUser =new InstagramUser(signUpDto.getUserFirstName(), signUpDto.getUserLastName(), signUpDto.getAge(), signUpDto.getUserEmail(),
                encryptedPassword,signUpDto.getUserContact());
        instagramUserRepository.save(instagramUser);

        // token creation and saving
        AuthenticationToken token=new AuthenticationToken(instagramUser);
        authenticationTokenService.saveToken(token);
        return new SignUpOutput("instagramUser registered","instagramUser created successfully");
    }

    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digested = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;
    }

    public SignInOutput signIn(SignInInput signInDto) {
        // get email
        // encrypt the password
        // match it with database encrypted password
        // figure out the token
        // set up output response
        InstagramUser instagramUser=instagramUserRepository.findFirstByEmail(signInDto.getInstagramUserEmail());
        if(instagramUser==null){
            throw new IllegalStateException("user invalid !!!....sign up instead");

        }
        String encryptedPassword=null;
        try {
            encryptedPassword=encryptPassword(signInDto.getInstagramUserPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        boolean isPasswordValid=encryptedPassword.equals(instagramUser.getPassword());
        if(!isPasswordValid){
            throw new IllegalStateException("user invalid!!!.....sign up instead");
        }
        // figue out the token
        AuthenticationToken authToken=authenticationTokenService.getToken(instagramUser);
        return new SignInOutput("Authentication successful",authToken.getToken());
    }
}




