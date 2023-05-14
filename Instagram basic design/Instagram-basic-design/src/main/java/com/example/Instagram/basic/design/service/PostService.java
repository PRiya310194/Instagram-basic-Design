package com.example.Instagram.basic.design.service;

import com.example.Instagram.basic.design.dao.PostRepository;
import com.example.Instagram.basic.design.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public String findById(Integer postId) {
        if (postRepository.findById(postId).isPresent()) {
            Post post = postRepository.findById(postId).get();
            return post.toString();
        } else {
            return "please enter valid postId";
        }
    }

    public List<Post> findAllPost() {
        return postRepository.findAll();
    }
}


