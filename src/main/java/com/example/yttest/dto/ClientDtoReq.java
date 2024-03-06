package com.example.yttest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;
@Data
//@NoArgsConstructor
@RequiredArgsConstructor
/**
 * DTO for {@link com.example.yttest.entity.Client}
 */
@Value
public class ClientDtoReq implements Serializable {
    @NotNull
    Boolean iscompany;
    @NotEmpty(message = "surname ne doit pas etre vide")
    String surname;
    @NotBlank(message = "surname ne doit pas etre vide")
    String firstname;
    String companyname;
    String btwnumber;
    String street;
    String postalcode;
    String city;
    String country;
    @NotEmpty(message = "surname ne doit pas etre vide")
    String email;
    String phonenumber;
    String mobilenumber;
    Instant createdAt;
    Instant updatedAt;
    int compagny_id=1;

}