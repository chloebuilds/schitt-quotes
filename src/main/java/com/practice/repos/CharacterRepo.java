package com.practice.repos;

import com.practice.models.SCCharacter;
import org.springframework.data.repository.CrudRepository;

public interface CharacterRepo extends CrudRepository<SCCharacter, Integer> {
}
