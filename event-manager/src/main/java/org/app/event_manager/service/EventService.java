package org.app.event_manager.service;

import org.app.event_manager.dao.model.Event;
import org.app.event_manager.dao.repositories.EventRepository;
import org.app.event_manager.web.ExceptionHandlers.ResourceNotFoundException;
import org.app.event_manager.web.dto.EventDto;
import org.app.event_manager.web.dto.TicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EventService {

    @Autowired
    EventRepository repository;

    @Autowired
    TicketService ticketService;



    public EventDto findByExternalId(UUID id) {
        Event event = repository.findByExternalId(id);

        if (event == null) {
            throw new ResourceNotFoundException("No event with id '" + id + "' found");
        }
        EventDto eventDto = new EventDto().fromEntity(event);
        return eventDto;
    }

    public EventDto findByName(String name) {
        Event event = repository.findByEventName(name);
        if (event == null) {
            throw new ResourceNotFoundException("No event with name '" + name + "' found");
        }

        return new EventDto().fromEntity(event);
    }

    @Transactional
    public EventDto create(EventDto eventDto) {
        Event event = eventDto.toEntity();
        repository.save(event);
        eventDto.fromEntity(event);
        return eventDto;

    }

    @Transactional
    public void delete(UUID id) {
        Event event = repository.findByExternalId(id);
        if (event == null) {
            throw new ResourceNotFoundException("No event with id '" + id + "' found");
        }
        repository.delete(event);
    }

    @Transactional
    public List<EventDto> listAll() {
        List<Event> events = repository.findAll();

        List<EventDto> eventDtos = new ArrayList<>();
        for (Event event:events) {
            EventDto eventDto = new EventDto().fromEntity(event);
            eventDtos.add(eventDto);
        }

        return eventDtos;
    }

    public List<TicketDto> findTickets(UUID id){
        Event event = repository.findByExternalId(id);
        if(event == null){
            throw new ResourceNotFoundException("No event with id '" + id + "' found");
        }
        return  ticketService.findByEvent(event);

    }
}
