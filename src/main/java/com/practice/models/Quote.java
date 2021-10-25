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

    @Column(name = "character", nullable = false)
    @NotEmpty(message = "Please provide a name")
    @NotNull
    private String schittCharacter;

    @Column (name = "quote", nullable = false)
    @NotEmpty(message = "Please provide a quote")
    @NotNull
    private String schittQuote;

    // ? Adding the relationship between quotes and characters
     //One quote relates to one character
    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
            )
    @JoinColumn(name = "character_id") // used to specify the foreign key column
    @JsonIgnoreProperties("quotes")
    //! what is this doing? mapped to itself at the moment??
    //  ! need to tell it what field it maps to on the many to one side
     //! Shouldn't it be mapped to character. When I did it didn't work
    private SCCharacter scCharacter;

}
