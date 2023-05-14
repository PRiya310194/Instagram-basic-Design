package com.example.Instagram.basic.design.controller;

import com.example.Instagram.basic.design.model.Post;
import com.example.Instagram.basic.design.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/savePost")
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        Post postData = postService.savePost(post);
        return new ResponseEntity<>(postData, HttpStatus.OK);
    }

    @GetMapping("/postId/{postId}")
    public ResponseEntity<String> getPostById(@PathVariable Integer postId) {
        if (postId != null) {
            String post = postService.findById(postId);
            return new ResponseEntity<>(post, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>("please enter valid postId", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/findAll")
    public List<Post> findAllPost() {
        return postService.findAllPost();
    }

}