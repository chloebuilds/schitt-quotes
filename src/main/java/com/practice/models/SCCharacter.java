package com.practice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @Column(name = "name")
    private String name;

    @Column(name = "bio")
    private String bio;

    @Column(name = "image")
    private String image;


    // Relationship between character and quotes
    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("character")
    private List<Quote> quotes;


    }

