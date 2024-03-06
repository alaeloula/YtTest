package com.example.yttest.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;
@RequiredArgsConstructor
@Data
/**
 * DTO for {@link com.example.yttest.entity.Car}
 */
//@Value
public class CarDtoRes implements Serializable {
    Integer id;
    String chassisnumber;
    String brand;
    String model;
    String cartype;
    String transmission;
    Instant firstregistration;
    Integer mileage;
    Integer enginepower;
    Integer cylinder;
    String fuel;
    String co2;
    String color;
    Integer numberkeys;
    Boolean cerofconf;
    Boolean inspectionform;
    Boolean carpass;
    Instant createdAt;
    Instant updatedAt;
}