package com.damian.boytchev.sport.ninja.SportNinja.model;

import com.damian.boytchev.sport.ninja.SportNinja.dto.EventDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Event extends Model {

    @NotNull
    private Integer playerRequired;

    @NotNull
    @Length(min = 6, max = 128)
    private String place;

    @NotNull
    @Length(min = 8, max = 256)
    private String description;

    @NotNull
    private Timestamp time;

    @NotNull
    @ManyToOne
    @JoinColumn
    private User createdBy;

    @NotNull
    @ManyToOne
    @JoinColumn
    private Sport sport;

    @ManyToMany(mappedBy = "participatingEvents")
    private List<User> participants;

    public Event(EventDto eventDto){
        super();
        setPlayerRequired(eventDto.getPlayersRequired());
        setPlace(eventDto.getPlace());
        setDescription(eventDto.getDescription());
        setTime(eventDto.getTime());
    }
}
