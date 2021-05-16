package org.app.event_manager.web.controllers;

import io.swagger.annotations.ApiOperation;
import org.app.event_manager.service.EventService;
import org.app.event_manager.service.TicketService;
import org.app.event_manager.web.dto.EventDto;
import org.app.event_manager.web.dto.TicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("events")
@CrossOrigin(origins = "*")
public class EventController {

    @Autowired
    EventService service;

    @Autowired
    TicketService ticketService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the event with the specified Id")
    public EventDto findById(@PathVariable UUID id) {
        return service.findByExternalId(id);
    }

    @RequestMapping(value = "/getEventByName", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the event with the specified name")
    public EventDto findByName(@RequestParam String name) {
        return service.findByName(name);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "Returns all events")
    public List<EventDto> listAll() {return service.listAll();}


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Deletes an event")
    public void delete(@PathVariable UUID id) {
        service.delete(id);

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Creates an event")
    public EventDto create(@Valid @RequestBody EventDto dto){

        return service.create(dto);
    }

    @RequestMapping(value = "/{id}/tickets", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Returns the list of tickets that are attached to a certain event")
    public List<TicketDto> findEventTickets(@PathVariable UUID id) {
        return service.findTickets(id);
    }


}
