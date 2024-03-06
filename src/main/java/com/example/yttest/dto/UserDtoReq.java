package com.example.yttest.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;
@Data
@RequiredArgsConstructor
/**
 * DTO for {@link com.example.yttest.entity.User}
 */

public class UserDtoReq implements Serializable {
    @NotNull
    String name;
    String email;

    Instant emailVerifiedAt;
    String password;
    String rememberToken;
    Instant createdAt;
    Instant updatedAt;
    int compagny_id=1;
}