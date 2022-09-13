package com.george.fashionBlog.service;

import com.george.fashionBlog.dto.PostDto;
import com.george.fashionBlog.model.Post;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    Post createPost(PostDto postDto);

     String deletePost(Long id);

     Post updatePost(Long id, PostDto postDto);
}
