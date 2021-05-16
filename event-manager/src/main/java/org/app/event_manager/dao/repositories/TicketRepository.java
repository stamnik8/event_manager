package org.app.event_manager.dao.repositories;

import org.app.event_manager.dao.model.Event;
import org.app.event_manager.dao.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByEvent(Event event);

    Ticket findByExternalId(UUID id);
}