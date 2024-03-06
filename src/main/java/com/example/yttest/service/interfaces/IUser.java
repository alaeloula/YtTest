package com.example.yttest.service.interfaces;



import com.example.yttest.dto.UserDtoReq;
import com.example.yttest.dto.UserDtoRes;


import java.util.List;

public interface IUser {
    List<UserDtoRes> findAll();

    UserDtoRes findById(Integer id);
    UserDtoRes createUser(UserDtoReq userDtoReq);

    long count();

    void deleteById(Integer id);

    UserDtoRes findByEmail(String email);
    UserDtoRes updateUser(int userId, UserDtoReq updatedUserDto);
}
