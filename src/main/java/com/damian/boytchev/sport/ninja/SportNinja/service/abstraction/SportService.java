package com.damian.boytchev.sport.ninja.SportNinja.service.abstraction;

import com.damian.boytchev.sport.ninja.SportNinja.model.Sport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface SportService {

    Sport create(Sport sport);
    Sport read(Sport sport);
    Sport update(Sport sport);
    Boolean delete(Sport sport);

    Sport getById(UUID sportId);
    Boolean deleteById(UUID sportId);
    List<Sport> findSports(Pageable pageable);
}
