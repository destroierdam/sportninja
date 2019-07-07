package com.damian.boytchev.sport.ninja.SportNinja.model;

import com.damian.boytchev.sport.ninja.SportNinja.dto.DayTimeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.sql.Time;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class DayTime extends Model {

    @NotNull
    private String day;

    @NotNull
    private Time time;

    @NotNull
    @ManyToOne
    @JoinColumn
    private User createdBy;

    public DayTime(DayTimeDto dayTimeDto){
        super();
        setDay(dayTimeDto.getDay());
        setTime(dayTimeDto.getTime());
    }

    public DayTimeDto getDayTimeDto(){
        DayTimeDto dayTimeDto = new DayTimeDto();
        dayTimeDto.setId(getId());
        dayTimeDto.setTime(getTime());
        dayTimeDto.setDay(getDay());

        return dayTimeDto;
    }
}
