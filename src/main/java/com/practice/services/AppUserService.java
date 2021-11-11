package com.practice.services;

import com.practice.models.AppUser;
import com.practice.repos.AppUserRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@Log4j2
public class AppUserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Inside of loadUserByUsername: {}", username);
        AppUser user = appUserRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    @Autowired
    private AppUserRepo appUserRepo;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AppUser createUser(AppUser appUser) {
        Optional<AppUser> existingUser = appUserRepo.findByUsername(appUser.getUsername());
        if (existingUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A user with that username already exists");
        }

//        if (!appUser.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$")) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad password");
//        }

        if (!appUser.getPassword().equals(appUser.getPasswordConfirmation())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Passwords don't match");
        }

//        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
//        appUser.setPassword(encodedPassword);


        return appUserRepo.save(appUser);
    }
}