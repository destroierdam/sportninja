package com.damian.boytchev.sport.ninja.SportNinja.service.implementation;

import com.damian.boytchev.sport.ninja.SportNinja.dao.EventRepository;
import com.damian.boytchev.sport.ninja.SportNinja.model.Event;
import com.damian.boytchev.sport.ninja.SportNinja.service.abstraction.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event create(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event update(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event read(Event event) {
        return eventRepository.getOne(event.getId());
    }

    @Override
    public Boolean delete(Event event) {
        if(!eventRepository.findById(event.getId()).isPresent()){
            return false;
        }
        eventRepository.delete(event);
        return true;
    }

    @Override
    public Event getEventById(UUID eventId) {
        return eventRepository.getOne(eventId);
    }

    @Override
    public Boolean deleteEventById(UUID eventId) {
        return null;
    }

    @Override
    public List<Event> getAllEvents(Pageable pageable) {
        return null;
    }
}
