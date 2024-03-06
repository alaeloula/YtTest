package com.example.yttest.controller;

import com.example.yttest.config.CustomUserDetailsService;
import com.example.yttest.config.JWTService;
import com.example.yttest.dto.UserDtoLogin;
import com.example.yttest.dto.UserDtoReq;
import com.example.yttest.dto.UserDtoRes;
import com.example.yttest.service.impl.UserService;
import com.example.yttest.service.interfaces.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUser userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private JWTService jwtService;
    private CustomUserDetailsService userDetailsService;

    public UserController(UserService userService, JWTService jwtService , CustomUserDetailsService userDetailsService) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping
    public List<UserDtoRes> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDtoRes getUserById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserDtoRes createUser(@RequestBody UserDtoReq userDtoReq) {
        return userService.createUser(userDtoReq);
    }

//    @PostMapping("/login")
//    public String getToken(@RequestBody UserDtoLogin loginRequest) {
//
//        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
//        if (passwordEncoder.matches(loginRequest.getPassword(),userDetails.getPassword())){
//            loginRequest.setRememberToken(jwtService.GenerateToken(userDetails));
//            String token = jwtService.GenerateToken(userDetails);
//            return token;
//        }
//       throw new InsufficientAuthenticationException("not access");
//    }
@PostMapping("/login")
public ResponseEntity<UserDtoRes> getToken(@RequestBody UserDtoLogin loginRequest) {
    UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
    if (passwordEncoder.matches(loginRequest.getPassword(), userDetails.getPassword())) {
        UserDtoRes user = userService.findByEmail(loginRequest.getEmail());
        String token = jwtService.GenerateToken(userDetails);
        user.setRememberToken(token);
        return ResponseEntity.ok(user);
    }
    throw new InsufficientAuthenticationException("Invalid credentials");
}
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDtoRes> updateUser(@PathVariable int id, @RequestBody UserDtoReq updatedUserDto) {
        System.out.println("here");
        UserDtoRes userDtoRes = userService.updateUser(id, updatedUserDto);
        return ResponseEntity.ok(userDtoRes);
    }
}

