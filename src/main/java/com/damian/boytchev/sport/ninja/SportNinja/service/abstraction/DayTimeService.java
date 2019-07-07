package com.damian.boytchev.sport.ninja.SportNinja.service.abstraction;

import com.damian.boytchev.sport.ninja.SportNinja.model.DayTime;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface DayTimeService {

    DayTime create(DayTime dayTime);
    DayTime read(DayTime dayTime);
    DayTime update(DayTime dayTime);
    void delete(DayTime dayTime);
    DayTime getDayTimeById(UUID id);
    Boolean deleteDayTimeById(UUID id);
    List<DayTime> findAllDateTimes(Pageable pageable);
}
