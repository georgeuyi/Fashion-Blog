package com.george.fashionBlog.service;

import com.george.fashionBlog.dto.LoginDto;
import com.george.fashionBlog.dto.UserDto;
import com.george.fashionBlog.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

     User createUser(UserDto userDto);
     User findUserByEmail(String email);
     String loginUser(LoginDto loginDto);

}
