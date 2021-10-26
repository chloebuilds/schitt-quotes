package com.practice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "characters")
public class SCCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @NotNull(message = "Please add the Schitt's Creek character's name")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @NotEmpty(message = "Please add the character's bio")
    @Column(name = "bio", nullable = false, length = 3000)
    private String bio;

    @Column(name = "image")
    private String image;

    // Relationship between character and quotes
    @OneToMany(mappedBy = "scCharacter", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("scCharacter")
    private List<Quote> quotes;


    }

