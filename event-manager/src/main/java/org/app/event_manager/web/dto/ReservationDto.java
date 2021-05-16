package org.app.event_manager.web.dto;

import lombok.Getter;
import lombok.Setter;
import org.app.event_manager.dao.Enums.ReservationStatus;
import org.app.event_manager.dao.model.Reservation;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;


@Getter
@Setter
public class ReservationDto implements Serializable {
    private UUID id;

    private ZonedDateTime date;

    @NotNull
    private int count;

    @NotNull
    private UUID ticketId;

    @NotNull
    private UUID userId;

    private ReservationStatus status;


    public ReservationDto() {

    }

    public ReservationDto(UUID externalId,ZonedDateTime date,
                          int count,UUID ticketId,UUID userId, ReservationStatus status) {
        this.id = externalId;
        this.date = date;
        this.count = count;
        this.ticketId = ticketId;
        this.userId = userId;
        this.status = status;
    }

    public ReservationDto fromEntity(Reservation reservation) {
        setDate(reservation.getDate());
        setCount(reservation.getCount());
        setId(reservation.getExternalId());
        setStatus(reservation.getStatus());
        if(reservation.getTicket() != null){
            setTicketId(reservation.getTicket().getExternalId());
        }
        if (reservation.getUser() != null){
            setUserId(reservation.getUser().getExternalId());
        }
        return this;
    }

    public Reservation toEntity() {
        Reservation reservation = new Reservation();

        return this.toEntity(reservation);
    }


    public Reservation toEntity(Reservation reservation) {
        reservation.setDate(getDate());
        reservation.setCount(getCount());
        return reservation;
    }

}
