package com.damian.boytchev.sport.ninja.SportNinja.controller;

import com.damian.boytchev.sport.ninja.SportNinja.dto.SportDto;
import com.damian.boytchev.sport.ninja.SportNinja.model.Sport;
import com.damian.boytchev.sport.ninja.SportNinja.service.abstraction.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/sports")
public class SportController {

    @Autowired
    private SportService sportService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<SportDto>> getAllSportsPaged(@RequestParam(value = "page", required = false) Integer page,
                                                         @RequestParam(value = "count", required = false) Integer count){

        if(page == null){
            page = 0;
        }
        if(count == null){
            count = 30;
        }
        List<Sport> sports = sportService.findSports(PageRequest.of(page,count));
        List<SportDto> sportDtos = sports.stream().map(Sport::getSportDto).collect(Collectors.toList());
        return new ResponseEntity<>(sportDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/{sportId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<SportDto> getSportById(@PathVariable UUID sportId){
        return new ResponseEntity<>(sportService.getById(sportId).getSportDto(),HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<SportDto> createSport(@RequestBody SportDto sport){
        Sport sportModel = new Sport(sport);
        return new ResponseEntity<>(sportService.create(sportModel).getSportDto(),HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{sportId}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteSport(@PathVariable UUID sportId){
        return new ResponseEntity<>(sportService.delete(sportService.getById(sportId)), HttpStatus.OK);
    }






}
