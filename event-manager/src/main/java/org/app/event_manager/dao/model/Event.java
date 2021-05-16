package org.app.event_manager.dao.model;


import lombok.Getter;
import lombok.Setter;
import org.app.event_manager.dao.Enums.EventCategory;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Event")
@Getter
@Setter
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventName;

    private String location;

    @Type(type = "uuid-char")
    private UUID externalId;

    private String description;

    private String imgUrl;

    @Enumerated(EnumType.STRING)
    private EventCategory category;

    @Column(name = "event_date")
    private ZonedDateTime dateOfEvent;

    private String lon;

    private String lat;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "event")
    Set<Ticket> tickets;

    public Event() {
        this.externalId = UUID.randomUUID();
    }

}

