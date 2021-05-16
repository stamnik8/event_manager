package org.app.event_manager.dao.repositories;

import org.app.event_manager.dao.model.Reservation;
import org.app.event_manager.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByUser(User user);
    Reservation findByExternalId(UUID id);
    // List<Reservation> findByTicket(Ticket ticket);
}
