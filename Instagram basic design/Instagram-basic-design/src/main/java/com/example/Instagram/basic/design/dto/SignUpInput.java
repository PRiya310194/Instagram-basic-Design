package com.example.Instagram.basic.design.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpInput {
    private String userFirstName;
    private String userLastName;
    private int age;
    private String userEmail;

    private String userPassword;
    private String userContact;
}
