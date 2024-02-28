package com.example.yttest.config;




import com.example.yttest.entity.User;
import com.example.yttest.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository dbUserRepository;

    public CustomUserDetailsService(UserRepository dbUserRepository) {
        this.dbUserRepository = dbUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("HERE");
        User user = dbUserRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return new User(user.getEmail(), user.getPassword());
    }

//    private List<GrantedAuthority> getGrantedAuthorities(String role) {
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        authorities.add(new SimpleGrantedAuthority(role));
//        //authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
//        return authorities;
//    }
}
