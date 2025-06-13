package com.EventManagementPortal.controller;

import com.EventManagementPortal.entity.Events;
import com.EventManagementPortal.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public String listEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "events";
    }

    @GetMapping("/events/new")
    public String createEventForm(Model model) {
        model.addAttribute("event", new Events());
        return "create_event";
    }

    @PostMapping("/events")
    public String saveEvent(@ModelAttribute("event") Events event) {
        eventService.saveEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/events/edit/{id}")
    public String editEventForm(@PathVariable Long id, Model model) {
        model.addAttribute("event", eventService.getEventById(id));
        return "edit_event";
    }

    @PostMapping("/events/{id}")
    public String updateEvent(@PathVariable Long id, @ModelAttribute("event") Events event) {
        event.setId(id);
        eventService.updateEvent(event);
        return "redirect:/events";
    }

    // ✅ Correct DELETE method mapping
    @DeleteMapping("/event/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEventById(id);
        return "redirect:/events";
    }
}
