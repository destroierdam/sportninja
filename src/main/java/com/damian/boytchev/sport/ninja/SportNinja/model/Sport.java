package com.damian.boytchev.sport.ninja.SportNinja.model;

import com.damian.boytchev.sport.ninja.SportNinja.dto.SportDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Sport extends Model {

    @NotNull
    @Length(min = 4,max = 64)
    private String name;

    @NotNull
    @Length(min = 8,max = 512)
    private String description;

    @NotNull
    private Integer numberOfPlayers;

    @NotNull
    @Length(min = 4,max = 24)
    private String type;

    @NotNull
    @Length(min = 4,max = 128)
    private String equipment;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Category> categories;

    @OneToMany(mappedBy = "sport", cascade = CascadeType.ALL)
    private List<Event> events;

    @ManyToMany(mappedBy = "sports")
    private List<User> participants;


    public Sport(SportDto sportDto){
        super();
        setName(sportDto.getName());
        setDescription(sportDto.getDescription());
        setNumberOfPlayers(sportDto.getNumberOfPlayers());
        setType(sportDto.getType());
        setEquipment(sportDto.getEquipment());
    }

    public SportDto getSportDto(){
        SportDto sportDto = new SportDto();
        sportDto.setId(getId());
        sportDto.setName(getName());
        sportDto.setDescription(getDescription());
        sportDto.setNumberOfPlayers(getNumberOfPlayers());
        sportDto.setType(getType());
        sportDto.setEquipment(getEquipment());

        return sportDto;
    }

    public void setSportDto(SportDto sportDto){
        setName(sportDto.getName());
        setDescription(sportDto.getDescription());
        setNumberOfPlayers(sportDto.getNumberOfPlayers());
        setType(sportDto.getType());
        setEquipment(sportDto.getEquipment());
    }
}
