package com.practice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private String schittCharacter;

    @Column (name = "quote", nullable = false)
    private String schittQuote;

    // ? Adding the relationship between quotes and characters
    // One quote relates to one character
    @OneToOne(optional = false,
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            })
    @JoinColumn(name = "character_id", nullable = false)
    @JsonIgnoreProperties("quotes")
    private SCCharacter character;

}
