package com.EventManagementPortal.service;

import com.EventManagementPortal.entity.Events;
import com.EventManagementPortal.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Events> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Events getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public Events saveEvent(Events event) {
        return eventRepository.save(event);
    }

    @Override
    public Events updateEvent(Events event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }
}