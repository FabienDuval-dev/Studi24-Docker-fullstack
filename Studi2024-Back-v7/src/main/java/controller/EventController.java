package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import entity.*;
import Service.EventService;
import util.AdminEndpoints;


@RestController
@RequestMapping(AdminEndpoints.ADMIN)
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping(AdminEndpoints.EVENTS)
    public void createEvent(@RequestBody Event event) {
        Event newEvent = new Event();;
    }
}

