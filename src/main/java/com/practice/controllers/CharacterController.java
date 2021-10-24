package com.practice.controllers;

import com.practice.models.SCCharacter;
import com.practice.services.CharacterService;
import org.hibernate.annotations.NotFound;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.xml.stream.events.Characters;
import java.util.Optional;

@RestController
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    // FIND ALL
    @GetMapping("/characters")
    public Iterable<SCCharacter> getCharacters() {
        return characterService.findAllCharacters();
    }

    // POST
    @PostMapping("/characters")
    public SCCharacter postCharacter(@Valid @RequestBody SCCharacter character) {
        return characterService.createCharacter(character);
    }

    // GET BY ID
    @GetMapping("/characters/{characterId}")
    public Optional<SCCharacter> getCharacter(@PathVariable Integer characterId) {

        return characterService.findCharacter(characterId);
    }

    // DELETE
    @DeleteMapping("/characters/{characterId}")
    public void deleteCharacter(@PathVariable Integer characterId) {

        characterService.deleteCharacter(characterId);
    }

    // EDIT
    @PutMapping("/characters/{characterId}")
    public SCCharacter putCharacter(@PathVariable Integer characterId,
                                    @RequestBody SCCharacter character) {
        return characterService.updateCharacter(characterId, character);
    }
}


