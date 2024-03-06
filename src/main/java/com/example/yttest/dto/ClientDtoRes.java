package com.example.yttest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.example.yttest.entity.Client}
 */

@Data
//@NoArgsConstructor
@RequiredArgsConstructor
public class ClientDtoRes implements Serializable{
    Integer id;
    Boolean iscompany;
    String surname;
    String firstname;
    String companyname;
    String btwnumber;
    String street;
    String postalcode;
    String city;
    String country;
    String email;
    String phonenumber;
    String mobilenumber;
    Instant createdAt;
    Instant updatedAt;
}