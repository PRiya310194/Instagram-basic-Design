package com.example.Instagram.basic.design.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
    @Data
    @Entity
    @Table(name="tbl_post")
    public class Post {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer postId;
        private Timestamp createdDate;
        private Timestamp updatedDate;
        private String postData;
        @ManyToOne
        @JoinColumn()
        private InstagramUser insUser;

    }

