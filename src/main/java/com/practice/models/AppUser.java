package com.practice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "users")
@Getter
@Setter
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // makes sure that the password is write-only, never returned in the response..
    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,}$")
    private String password;

    @Transient // means that the passwordConfirmation isn't stored to the database, it's a temporary field to check the users password before registration
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordConfirmation;

}
