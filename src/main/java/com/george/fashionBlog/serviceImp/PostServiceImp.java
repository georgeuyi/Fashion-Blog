package com.george.fashionBlog.serviceImp;

import com.george.fashionBlog.dto.PostDto;
import com.george.fashionBlog.model.Post;
import com.george.fashionBlog.repository.PostRepository;
import com.george.fashionBlog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PostServiceImp implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImp(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setCreatedDate(LocalDate.now());
        return postRepository.save(post);
    }

    @Override
    public String deletePost(Long id) {
        this.postRepository.deleteById(id);
        return "";
    }

    @Override
    public Post updatePost(Long id, PostDto postDto) {
        Optional<Post> optional = postRepository.findById(id);
        Post post = null;
        if(optional.isPresent()){
            post = optional.get();
        }
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setUpdatedDate(LocalDate.now());

        return postRepository.save(post);
    }
}
