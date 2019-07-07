package com.damian.boytchev.sport.ninja.SportNinja.model;

import com.damian.boytchev.sport.ninja.SportNinja.dto.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Category extends Model {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @ManyToMany(mappedBy = "categories")
    private List<Sport> sports;

    public Category(CategoryDto categoryDto){
        super();
        setName(categoryDto.getName());
        setDescription(categoryDto.getDescription());
    }
}
