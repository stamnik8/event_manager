package org.app.event_manager.dao.model;

import lombok.Getter;
import lombok.Setter;
import org.app.event_manager.dao.Enums.ReservationStatus;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "Reservation")
@Getter
@Setter
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user")
    private User user;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    @Type(type = "uuid-char")
    private UUID externalId;

    private ZonedDateTime date;

    private int count;

    public  Reservation(){
        this.externalId = UUID.randomUUID();
    }
}
