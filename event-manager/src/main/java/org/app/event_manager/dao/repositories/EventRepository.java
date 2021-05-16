package org.app.event_manager.dao.repositories;

import org.app.event_manager.dao.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, Long> {

    Event findByExternalId(UUID id);

    Event findByEventName(String name);
    //  Event findByLocation(String location);
}
