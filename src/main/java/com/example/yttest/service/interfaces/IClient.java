package com.example.yttest.service.interfaces;



import com.example.yttest.dto.ClientDtoReq;
import com.example.yttest.dto.ClientDtoRes;

import java.util.List;

public interface IClient {
    List<ClientDtoRes> findAll();

    ClientDtoRes findById(Integer id);
    ClientDtoRes createUser(ClientDtoReq clientCreateDto);

    long count();

    void deleteById(Integer id);
}
