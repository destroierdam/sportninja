package com.damian.boytchev.sport.ninja.SportNinja.model;

import ch.qos.logback.core.util.TimeUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;


@AllArgsConstructor
@Data
@EqualsAndHashCode
@MappedSuperclass
public abstract class Model implements Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    private Timestamp createdAt;

    @NotNull
    private Timestamp modifiedAt;

    public Model(){
        setCreatedAt(new Timestamp(System.currentTimeMillis()));
        setModifiedAt(new Timestamp(System.currentTimeMillis()));
    }

}
