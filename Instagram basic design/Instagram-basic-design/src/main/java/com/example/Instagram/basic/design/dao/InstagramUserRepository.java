package com.example.Instagram.basic.design.dao;

import com.example.Instagram.basic.design.model.InstagramUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstagramUserRepository extends JpaRepository<InstagramUser,Integer> {
    InstagramUser findFirstByEmail(String userEmail);
}
