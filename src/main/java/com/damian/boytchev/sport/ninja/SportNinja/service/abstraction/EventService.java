package com.damian.boytchev.sport.ninja.SportNinja.service.abstraction;

import com.damian.boytchev.sport.ninja.SportNinja.model.Event;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

@Service
public interface EventService {

    Event create(Event event);
    Event update(Event event);
    Event read(Event event);
    Boolean delete(Event event);
    Event getEventById(UUID eventId);
    Boolean deleteEventById(UUID eventId);
    List<Event> getAllEvents(Pageable pageable);


}
