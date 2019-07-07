package com.damian.boytchev.sport.ninja.SportNinja.dao;

import com.damian.boytchev.sport.ninja.SportNinja.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
