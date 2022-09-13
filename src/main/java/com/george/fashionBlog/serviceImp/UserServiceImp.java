package com.george.fashionBlog.serviceImp;

import com.george.fashionBlog.dto.LoginDto;
import com.george.fashionBlog.dto.UserDto;
import com.george.fashionBlog.execption.UserNotFountException;
import com.george.fashionBlog.model.User;
import com.george.fashionBlog.repository.UserRepository;
import com.george.fashionBlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(()->new UserNotFountException("This email does not exist: "+email));
    }

    @Override
    public String loginUser(LoginDto loginDto) {
        User visitor = findUserByEmail(loginDto.getEmail());
        if(visitor != null && visitor.getPassword().equals(loginDto.getPassword())) return "Login successful";
        return "Invalid password";
    }
}
