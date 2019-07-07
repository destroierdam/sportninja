package com.damian.boytchev.sport.ninja.SportNinja.service.implementation;

import com.damian.boytchev.sport.ninja.SportNinja.dao.DayTimeRepository;
import com.damian.boytchev.sport.ninja.SportNinja.model.DayTime;
import com.damian.boytchev.sport.ninja.SportNinja.service.abstraction.DayTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DayTimeServiceImpl implements DayTimeService {

    @Autowired
    private DayTimeRepository dayTimeRepository;

    @Override
    public DayTime create(DayTime dayTime) {
        return dayTimeRepository.save(dayTime);
    }

    @Override
    public DayTime read(DayTime dayTime) {
        return dayTimeRepository.findById(dayTime.getId()).get();
    }

    @Override
    public DayTime update(DayTime dayTime) {
        return dayTimeRepository.save(dayTime);
    }

    @Override
    public void delete(DayTime dayTime) {
        dayTimeRepository.delete(dayTime);
    }

    @Override
    public DayTime getDayTimeById(UUID id) {
        return dayTimeRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteDayTimeById(UUID id) {
        Optional<DayTime> dayTime = dayTimeRepository.findById(id);
        if(dayTime.isPresent()){
            dayTimeRepository.delete(dayTime.get());
            return true;
        }
        return false;
    }

    @Override
    public List<DayTime> findAllDateTimes(Pageable pageable) {
        return dayTimeRepository.findAll(pageable).getContent();
    }
}
