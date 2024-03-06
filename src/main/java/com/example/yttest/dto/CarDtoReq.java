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
@Value
public class CarDtoReq implements Serializable {
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
    Boolean registerCert;
    Boolean cerofconf;
    Boolean inspectionform;
    Boolean carpass;
    Instant createdAt;
    Instant updatedAt;
    int compagny_id=1;
}