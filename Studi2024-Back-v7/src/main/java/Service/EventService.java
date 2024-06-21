package Service;

import entity.Event;
import repository.EventRepository;

import java.util.Date;

import entity.Client;
import repository.ClientRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Client client, Date date, String location) {
        Event event = new Event();
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        eventRepository.delete(event);
    }
}
