package com.example.yttest.dto;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Data
//@NoArgsConstructor
@RequiredArgsConstructor
/**
 * DTO for {@link com.example.yttest.entity.User}
 */

public class UserDtoRes implements Serializable {
    Integer id;
    String name;
    String email;
    Instant emailVerifiedAt;
    String password;
    String rememberToken;
    Instant createdAt;
    Instant updatedAt;
}