package com.example.Instagram.basic.design.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
@Data
@Entity
@NoArgsConstructor
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tokenId;
    private String token;
    private LocalDate tokenCreationDate;
    @OneToOne()
    @JoinColumn(nullable=false,name="fk_instagramUser_ID")
    private InstagramUser instagramUser;

    public AuthenticationToken(InstagramUser instagramUser) {
        this.instagramUser = instagramUser;
        this.tokenCreationDate=LocalDate.now();
        this.token= UUID.randomUUID().toString();
    }



}
