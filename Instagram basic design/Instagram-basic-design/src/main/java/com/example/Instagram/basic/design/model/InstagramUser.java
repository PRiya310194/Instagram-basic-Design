package com.example.Instagram.basic.design.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class InstagramUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer InstagramUserId;
    private String firstName;
    private String lastName;
    private Integer age;
    private String password;
    private String email;
    private String phoneNumber;

    public InstagramUser(String firstName, String lastName, Integer age, String password, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}

