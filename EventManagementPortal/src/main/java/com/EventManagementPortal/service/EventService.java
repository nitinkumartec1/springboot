package com.EventManagementPortal.service;

import com.EventManagementPortal.entity.Events;
import java.util.List;

public interface EventService {
    List<Events> getAllEvents();
    Events getEventById(Long id);
    Events saveEvent(Events event);
    Events updateEvent(Events event);
    void deleteEventById(Long id);
}