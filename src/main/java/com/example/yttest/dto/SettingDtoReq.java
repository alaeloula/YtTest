package com.example.yttest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;
@Data
@RequiredArgsConstructor
/**
 * DTO for {@link com.example.yttest.entity.Setting}
 */
//@Value
public class SettingDtoReq implements Serializable {
    String companyLogo;
    String companyName;
    String ownerName;
    String ownerLastname;
    String vatNumber;
    String street;
    String zipCode;
    String city;
    String country;
    String ownerEmail;
    String ownerPhone;
    String ownerWebsite;
    String bankName;
    String bankAccountNumber;
    String bicNumber;
    String bankName2;
    String bankAccountNumber2;
    String bicNumber2;
    Instant createdAt;
    Instant updatedAt;
}