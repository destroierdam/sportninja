package com.damian.boytchev.sport.ninja.SportNinja.service.implementation;

import com.damian.boytchev.sport.ninja.SportNinja.dao.SportRepository;
import com.damian.boytchev.sport.ninja.SportNinja.model.Sport;
import com.damian.boytchev.sport.ninja.SportNinja.service.abstraction.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SportServiceImpl implements SportService {

    @Autowired
    private SportRepository sportRepository;

    @Override
    public Sport create(Sport sport) {
        return sportRepository.save(sport);
    }

    @Override
    public Sport read(Sport sport) {
        return sportRepository.getOne(sport.getId());
    }

    @Override
    public Sport update(Sport sport) {
        Sport updated = sportRepository.getOne(sport.getId());
        if(updated != null){
            return sportRepository.save(sport);
        }
        return null;
    }

    @Override
    public Boolean delete(Sport sport) {
        Sport deleted = sportRepository.getOne(sport.getId());
        if(deleted != null){
            sportRepository.delete(sport);
            return true;
        }
        return false;
    }

    @Override
    public Sport getById(UUID sportId) {
        return sportRepository.getOne(sportId);
    }

    @Override
    public Boolean deleteById(UUID sportId) {
        return delete(sportRepository.getOne(sportId));
    }

    @Override
    public List<Sport> findSports(Pageable pageable) {
        return sportRepository.findAll(pageable).getContent();
    }
}
