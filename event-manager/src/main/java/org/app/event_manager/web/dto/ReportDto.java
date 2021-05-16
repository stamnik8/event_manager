package org.app.event_manager.web.dto;

import lombok.Getter;
import lombok.Setter;
import org.app.event_manager.dao.Enums.ReservationStatus;
import org.app.event_manager.dao.Enums.TicketClasses;
import org.app.event_manager.dao.model.Reservation;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;



@Getter
@Setter
public class ReportDto implements Serializable {

    private UUID id;

    private ZonedDateTime date;

    @NotNull
    private int count;


    @NotNull
    private String  userName;

    private ReservationStatus status;

    @NotNull
    private String eventName;


    private TicketClasses category;


    public ReportDto() {

    }

    public ReportDto(UUID id,ZonedDateTime date ,int a ,String username,
                     ReservationStatus status,
                     String eventname,TicketClasses type ){
        this.id = id;
        this.date = date;
        this.count = a;
        this.userName= username;
        this.eventName = eventname;
        this.status = status;
        this.category = type;
    }


    public ReportDto fromEntity(Reservation reservation) {
        setDate(reservation.getDate());
        setCount(reservation.getCount());
        setId(reservation.getExternalId());
        setStatus(reservation.getStatus());
        if(reservation.getTicket() != null){
            setEventName(reservation.getTicket().getEvent().getEventName());
            setCategory(reservation.getTicket().getType());
        }
        if (reservation.getUser() != null){
            setUserName(reservation.getUser().getUsername());
        }
        return this;
    }



}