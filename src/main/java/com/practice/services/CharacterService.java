package com.practice.services;

import com.practice.models.SCCharacter;
import com.practice.repos.CharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepo characterRepo;

    public Iterable<SCCharacter> findAllCharacters() {
        return characterRepo.findAll();
    }

    public SCCharacter createCharacter(SCCharacter character) {
        return characterRepo.save(character);
    }

    public Optional<SCCharacter> findCharacter(Integer characterId) {
        Optional<SCCharacter> optCharacter = characterRepo.findById(characterId);
        if (optCharacter.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found");
        }
        return optCharacter;
    }

    public void deleteCharacter(Integer characterId) {
        Optional<SCCharacter> optCharacter = characterRepo.findById(characterId);
        if (optCharacter.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found");
        }
        characterRepo.deleteById(characterId);
    }

    public SCCharacter updateCharacter(Integer characterId, SCCharacter character) {
        Optional<SCCharacter> optCharacter = characterRepo.findById(characterId);
        if (optCharacter.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found");
        }
        SCCharacter characterToUpdate = optCharacter.get();
        characterToUpdate.setName(character.getName());
        characterToUpdate.setBio(character.getBio());
        characterToUpdate.setImage(character.getImage());
        return characterRepo.save(characterToUpdate);
    }

}
