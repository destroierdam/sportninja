package com.damian.boytchev.sport.ninja.SportNinja.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class UserDto {

    private UUID id;

    private String fullName;

    private String email;

    private String username;

    private String password;

    private String phoneNumber;

    private Double rating;
}
