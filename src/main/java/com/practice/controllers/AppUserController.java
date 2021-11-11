package com.practice.controllers;

import com.practice.models.AppUser;
import com.practice.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
    public class AppUserController {

        @Autowired
        private AppUserService appUserService;

        // ! Register a new appUser
        @PostMapping("/register")
        public AppUser register(@Valid @RequestBody AppUser user) {
            return appUserService.createUser(user);
        }
    }

