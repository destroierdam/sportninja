package com.damian.boytchev.sport.ninja.SportNinja.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class DayTimeDto {

    private UUID id;

    private String day;

    private Time time;
}
