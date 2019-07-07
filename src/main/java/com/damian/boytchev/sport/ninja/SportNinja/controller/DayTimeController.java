package com.damian.boytchev.sport.ninja.SportNinja.controller;

import com.damian.boytchev.sport.ninja.SportNinja.dto.DayTimeDto;
import com.damian.boytchev.sport.ninja.SportNinja.model.DayTime;
import com.damian.boytchev.sport.ninja.SportNinja.service.abstraction.DayTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/daytime")
public class DayTimeController {

    @Autowired
    private DayTimeService dayTimeService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<DayTimeDto>> getAllDayTimes(@RequestParam(value = "page", required = false) Integer page,
                                                           @RequestParam(value = "count", required = false) Integer count){
        if(page == null){
            page = 0;
        }
        if(count == null){
            count = 30;
        }

        return new ResponseEntity<>(dayTimeService.findAllDateTimes(PageRequest.of(page,count)).stream()
                .map(DayTime::getDayTimeDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<DayTimeDto> getDayTimeById(@PathVariable UUID id){
        return new ResponseEntity<>(dayTimeService.getDayTimeById(id).getDayTimeDto(), HttpStatus.OK);
    }

    @RequestMapping(value = "/" , method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<DayTimeDto> createDayTime(@RequestBody DayTimeDto dayTime) {
        DayTime dayTimeModel = new DayTime(dayTime);
        return new ResponseEntity<>(dayTimeService.create(dayTimeModel).getDayTimeDto(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<DayTimeDto> updateDayTime(@RequestBody DayTimeDto dayTime){
        DayTime dayTimeModel = new DayTime(dayTime);
        return new ResponseEntity<>(dayTimeService.update(dayTimeModel).getDayTimeDto(),HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteDayTime(@PathVariable UUID id){
        return new ResponseEntity<>(dayTimeService.deleteDayTimeById(id), HttpStatus.OK);
    }
}
