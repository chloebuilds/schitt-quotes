package com.practice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "quotes")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "character")
    private String schittCharacter;

    @Column (name = "quote", nullable = false)
    @NotEmpty(message = "Please provide a quote")
    @NotNull
    private String schittQuote;

    // ? Adding the relationship between quotes and characters
    // Many quotes can be attributed to one character
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
    })
    @JoinColumn(name = "character_id") // used to specify the foreign key column
    @JsonIgnoreProperties("quotes")
    //! what is this doing? mapped to itself at the moment??
    //  ! need to tell it what field it maps to on the many to one side
     //! Shouldn't it be mapped to character. When I did it didn't work
    private SCCharacter scCharacter;

}
