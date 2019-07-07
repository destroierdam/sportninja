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
public class CategoryDto {

    private UUID id;

    private String name;

    private String description;
}
