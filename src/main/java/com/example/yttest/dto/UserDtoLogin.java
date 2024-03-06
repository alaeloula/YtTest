package com.example.yttest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDtoLogin
{
    @NonNull
    private String email;
    @NonNull private String password;
    String rememberToken;
}
