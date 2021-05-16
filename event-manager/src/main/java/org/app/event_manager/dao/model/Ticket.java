package org.app.event_manager.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.app.event_manager.dao.Enums.TicketClasses;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "Ticket")
@Getter
@Setter
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int pool_size;

    private int cost;

    @Enumerated(EnumType.STRING)
    private TicketClasses type;

    @Type(type = "uuid-char")
    private UUID externalId;


    @OneToMany(mappedBy = "ticket")
    private List<Reservation> reservations;

    @ManyToOne(fetch = FetchType.EAGER)
    private Event event;

    public Ticket(){
        this.externalId = UUID.randomUUID();
    }


}

