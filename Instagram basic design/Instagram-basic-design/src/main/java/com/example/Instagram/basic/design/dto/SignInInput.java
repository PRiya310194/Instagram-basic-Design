package com.example.Instagram.basic.design.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInInput {
    private String instagramUserEmail;
    private String instagramUserPassword;
}