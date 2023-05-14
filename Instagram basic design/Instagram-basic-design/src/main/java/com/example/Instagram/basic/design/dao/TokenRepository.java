package com.example.Instagram.basic.design.dao;

import com.example.Instagram.basic.design.model.AuthenticationToken;
import com.example.Instagram.basic.design.model.InstagramUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken,Integer> {
    AuthenticationToken findByInstagramUser(InstagramUser instagramUser);
}
