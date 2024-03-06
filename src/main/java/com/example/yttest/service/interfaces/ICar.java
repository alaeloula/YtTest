package com.example.yttest.service.interfaces;

import com.example.yttest.dto.CarDtoReq;
import com.example.yttest.dto.CarDtoRes;
import com.example.yttest.entity.Car;

import java.util.List;

public interface ICar {
    List<CarDtoRes> findAll();

    CarDtoRes findById(Integer id);
    CarDtoRes createUser(CarDtoReq carCreateDto);

    long count();

    void deleteById(Integer id);


}
