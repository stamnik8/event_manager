package org.app.event_manager.web.controllers;

import io.swagger.annotations.ApiOperation;
import org.app.event_manager.service.ReservationService;
import org.app.event_manager.service.TicketService;
import org.app.event_manager.web.dto.TicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("tickets")
@CrossOrigin(origins = "*")
public class TicketController {

    @Autowired
    TicketService service;

    @Autowired
    ReservationService reservationService;

    @RequestMapping(value = "/{id}/updateBalance", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Decreases the number of available tickets")
    public void updateBalance(@PathVariable UUID id, @RequestParam int sumOfTickets) {
        service.decreasePool(id, sumOfTickets);
    }

    @RequestMapping(value = "/{id}/increasePool", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Increases the number of available tickets (pool size)")
    public void increasePool(@PathVariable UUID id, @RequestParam int increment) {
        service.increasePool(id, increment);
    }



    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Creates a ticket")
    public TicketDto create(@RequestBody TicketDto ticketDto/*@RequestParam UUID eventId*/) {
        return service.create(ticketDto);
    }
}
