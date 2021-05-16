package org.app.event_manager.web.dto;

import lombok.Getter;
import lombok.Setter;
import org.app.event_manager.dao.Enums.TicketClasses;
import org.app.event_manager.dao.model.Ticket;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class TicketDto implements Serializable {

    private UUID id;

    @NotNull(message = "Pool size can't be null")
    @Min(1)
    private int pool_size;

    @NotNull
    @Min(1)
    private int cost;

    @NotNull
    private TicketClasses type;

    @NotNull
    private UUID eventId;

    public TicketDto() {

    }

    public TicketDto(UUID id, int pool_size, int cost, TicketClasses type, UUID eventId) {
        this.id = id;
        this.pool_size = pool_size;
        this.cost = cost;
        this.type = type;
        this.eventId = eventId;
    }



    public TicketDto fromEntity(Ticket ticket) {

        setId(ticket.getExternalId());
        setPool_size(ticket.getPool_size());
        if (ticket.getEvent() != null) {
            setEventId(ticket.getEvent().getExternalId());
        }
        setType(ticket.getType());
        setCost(ticket.getCost());

        return this;
    }

    public Ticket toEntity() {

        Ticket ticket = new Ticket();
        return this.toEntity(ticket);
    }

    public Ticket toEntity(Ticket ticket) {
        ticket.setPool_size(getPool_size());
        ticket.setCost(getCost());
        ticket.setType(getType());

        return ticket;

    }

}
