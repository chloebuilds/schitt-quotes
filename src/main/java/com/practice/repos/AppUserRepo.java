package com.practice.repos;

import com.practice.models.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppUserRepo extends CrudRepository<AppUser, Integer> {
    // ! We will use this method later as part of authorization process.
    public Optional<AppUser> findByUsername(String username);

}
