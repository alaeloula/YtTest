package com.example.yttest.service.impl;


import com.example.yttest.dto.UserDtoReq;
import com.example.yttest.dto.UserDtoRes;

import com.example.yttest.entity.Setting;
import com.example.yttest.entity.User;

import com.example.yttest.repository.SettingRepository;
import com.example.yttest.repository.UserRepository;
import com.example.yttest.service.interfaces.IUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserService implements IUser {
    private final UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UserDtoRes> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDtoRes findById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
        return convertToDto(user);
    }

    @Override
    public UserDtoRes createUser(UserDtoReq userCreateDto) {
        User user = convertToEntity(userCreateDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User saveduser = userRepository.save(user);
        return convertToDto(saveduser);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDtoRes findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + email));
        return convertToDto(user);
    }
    @Override
    public UserDtoRes updateUser(int userId, UserDtoReq updatedUserDto) {
        System.out.println("here");
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id " + userId));
        existingUser.setName(updatedUserDto.getName());
        existingUser.setEmail(updatedUserDto.getEmail());
        existingUser.setPassword(passwordEncoder.encode(updatedUserDto.getPassword()));
        //existingUser.setCompanyId(updatedUserDto.getCompanyId());
        User savedUser = userRepository.save(existingUser);
        return convertToDto(savedUser);
    }

    private UserDtoRes convertToDto(User user) {
        return modelMapper.map(user, UserDtoRes.class);
    }

    private User convertToEntity(UserDtoReq settingDtoReq) {
        return modelMapper.map(settingDtoReq, User.class);
    }
}

