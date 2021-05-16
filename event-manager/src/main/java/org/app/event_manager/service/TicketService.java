package org.app.event_manager.service;

import org.app.event_manager.dao.model.Event;
import org.app.event_manager.dao.model.Ticket;
import org.app.event_manager.dao.repositories.EventRepository;
import org.app.event_manager.dao.repositories.TicketRepository;
import org.app.event_manager.web.ExceptionHandlers.BadRequestException;
import org.app.event_manager.web.ExceptionHandlers.TicketBalanceException;
import org.app.event_manager.web.dto.TicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    TicketRepository repository;

    @Autowired
    EventRepository eventRepository;

    @Transactional
    public TicketDto create(TicketDto ticketDto) {
        Ticket ticket = ticketDto.toEntity();
        if(ticketDto.getEventId() == null){
            throw new BadRequestException("Null event Id");
        }
        Event event = eventRepository.findByExternalId(ticketDto.getEventId());
        if(event == null){
            throw new BadRequestException("No event with id '"+ ticketDto.getEventId()+ "' found");
        }
        ticket.setEvent(event);
        repository.save(ticket);
        ticketDto.fromEntity(ticket);

        return ticketDto;
    }

    @Transactional
    public void decreasePool(UUID id, int sumOfTickets) {
        Ticket ticket = repository.findByExternalId(id);
        int balance = ticket.getPool_size() - sumOfTickets;
        if (balance < 0) {
            throw new TicketBalanceException("Not enough tickets");
        }
        ticket.setPool_size(balance);
        repository.save(ticket);
    }

    @Transactional
    public void increasePool(UUID id, int sumOfTickets) {
        Ticket ticket = repository.findByExternalId(id);
        ticket.setPool_size(ticket.getPool_size() + sumOfTickets);

        repository.save(ticket);
    }

    public List<TicketDto> findByEvent(Event event) {
        List<Ticket> tickets = repository.findByEvent(event);

        return tickets.stream()
                .map(ticket -> new TicketDto().fromEntity(ticket))
                .collect(Collectors.toList());

    }


}