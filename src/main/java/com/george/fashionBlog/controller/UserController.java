package com.george.fashionBlog.controller;

import com.george.fashionBlog.dto.LoginDto;
import com.george.fashionBlog.dto.PostDto;
import com.george.fashionBlog.dto.UserDto;
import com.george.fashionBlog.response.AllResponses;
import com.george.fashionBlog.service.PostService;
import com.george.fashionBlog.service.UserService;
import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;
    private PostService postService;

    @Autowired
    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<Object>createUser(@RequestBody UserDto userDto){
        return AllResponses.generateResponse("successful", HttpStatus.OK, userService.createUser(userDto));
    }

    @PostMapping("/createPost")
    public ResponseEntity<Object> createPost(@RequestBody PostDto postDto){
        return AllResponses.generateResponse ("successful", HttpStatus.OK, postService.createPost(postDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable(value = "id")Long id){

        return AllResponses.generateResponse("Post deleted", HttpStatus.OK, postService.deletePost(id));

    }

    @PutMapping("/updatePost/{id}")
    public ResponseEntity<Object> updatePost(@PathVariable(value = "id")Long id, @RequestBody PostDto postDto){
        return AllResponses.generateResponse("Successfully updated", HttpStatus.OK, postService.updatePost(id, postDto));
    }

    @GetMapping("/loginUser/{email}/{password}")

    public ResponseEntity<Object> loginUser(@PathVariable(value = "email")String email,
                                            @PathVariable(value = "password")String password,
                                            @RequestBody LoginDto loginDto){
        return AllResponses.generateResponse("Access Allowed", HttpStatus.OK, userService.loginUser(loginDto));
    }


}
