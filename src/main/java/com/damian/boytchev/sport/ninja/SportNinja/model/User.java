package com.damian.boytchev.sport.ninja.SportNinja.model;

import com.damian.boytchev.sport.ninja.SportNinja.Constants;
import com.damian.boytchev.sport.ninja.SportNinja.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.util.List;

@Table(name = "users")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends Model {

    @NotNull
    @Length(min = 4, max = 64)
    private String fullName;

    @NotNull
    @Length(min = 6,max = 128)
    @Pattern(regexp = Constants.email_regex)
    @Column(unique = true)
    private String email;

    @NotNull
    @Length(min = 6, max = 128)
    @Column(unique = true)
    private String username;

    @NotNull
    @Length(min = 8, max = 64)
    private String password;

    @NotNull
    @Length(min = 5, max = 32)
    @Pattern(regexp = Constants.phone_regex)
    private String phoneNumber;

    @NotNull
    private Double rating;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable
    private List<Sport> sports;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "createdBy", cascade = CascadeType.ALL)
    private List<DayTime> available;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "createdBy", cascade = CascadeType.ALL)
    private List<Event> hostingEvents;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable
    private List<Event> participatingEvents;

    public User(UserDto userDto){
        super();
        setFullName(userDto.getFullName());
        setEmail(userDto.getEmail());
        setUsername(userDto.getUsername());
        setPassword(userDto.getPassword());
        setPhoneNumber(userDto.getPhoneNumber());
        setRating(userDto.getRating());
    }

    public UserDto getUserDto(){
        UserDto userDto = new UserDto();
        userDto.setId(getId());
        userDto.setFullName(getFullName());
        userDto.setEmail(getEmail());
        userDto.setUsername(getUsername());
        userDto.setPassword(getPassword());
        userDto.setPhoneNumber(getPhoneNumber());
        userDto.setRating(getRating());

        return userDto;
    }

    public void setUserDto(UserDto userDto){
        setFullName(userDto.getFullName());
        setEmail(userDto.getEmail());
        setUsername(userDto.getUsername());
        setPassword(userDto.getPassword());
        setPhoneNumber(userDto.getPhoneNumber());
        setRating(userDto.getRating());
    }

}
