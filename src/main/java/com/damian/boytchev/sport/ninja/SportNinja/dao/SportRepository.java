package com.damian.boytchev.sport.ninja.SportNinja.dao;

import com.damian.boytchev.sport.ninja.SportNinja.model.Sport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SportRepository extends JpaRepository<Sport, UUID> {

    Page<Sport> findAll(Pageable pageable);
}
