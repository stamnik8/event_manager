package org.app.event_manager.service;

import org.app.event_manager.dao.Enums.ReservationStatus;
import org.app.event_manager.dao.model.Reservation;
import org.app.event_manager.dao.model.Ticket;
import org.app.event_manager.dao.model.User;
import org.app.event_manager.dao.repositories.ReservationRepository;
import org.app.event_manager.dao.repositories.TicketRepository;
import org.app.event_manager.dao.repositories.UserRepository;
import org.app.event_manager.web.ExceptionHandlers.BadRequestException;
import org.app.event_manager.web.ExceptionHandlers.ResourceNotFoundException;
import org.app.event_manager.web.dto.ReportDto;
import org.app.event_manager.web.dto.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class ReservationService {

    @Autowired
    ReservationRepository repository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketService ticketService;


    public List<ReportDto> findByUser(UUID userId) {
        User user= userRepository.findByExternalId(userId);
        if(user == null){
            throw new ResourceNotFoundException("No user found with Id: '" +userId +"'");
        }

        return user.getReservations().stream()
                .map(reservation -> new ReportDto().fromEntity(reservation))
                .collect(Collectors.toList());
    }

    public ReservationDto findById(UUID id) {
        Reservation reservation = repository.findByExternalId(id);
        if (reservation == null) {
            throw new ResourceNotFoundException("No Reservations found");
        }
        ReservationDto dto = new ReservationDto().fromEntity(reservation);

        return dto;
    }

    @Transactional
    public ReservationDto create(ReservationDto reservationDto) {
        if(reservationDto.getTicketId() == null){
            throw new BadRequestException("Null ticket id");
        }
        Ticket ticket = ticketRepository.findByExternalId(reservationDto.getTicketId());
        if(ticket == null){
            throw new BadRequestException("No ticket with id '" + reservationDto.getTicketId() + "' found");
        }
        if(reservationDto.getUserId() == null){
            throw new BadRequestException("Null user id");
        }
        User user = userRepository.findByExternalId(reservationDto.getUserId());
        if(user == null){
            throw new BadRequestException("No ticket with id '" + reservationDto.getUserId()+ "' found");
        }
        ticketService.decreasePool(ticket.getExternalId(), reservationDto.getCount());
        Reservation reservation = reservationDto.toEntity();
        reservation.setTicket(ticket);
        reservation.setUser(user);
        reservation.setStatus(ReservationStatus.RESERVED);
        repository.save(reservation);
        reservationDto.fromEntity(reservation);

        return reservationDto;
    }

    @Transactional
    public boolean cancel(UUID id) {
        Reservation reservation = repository.findByExternalId(id);
        if (reservation == null|| reservation.getStatus()== null) {
            throw new ResourceNotFoundException("Reservation not found");
        }
        if (reservation.getStatus()!= ReservationStatus.RESERVED) {
            throw new BadRequestException("Already Canceled");
        }
        reservation.setStatus(ReservationStatus.CANCELED);
        ticketService.increasePool(reservation.getTicket().getExternalId(), reservation.getCount());

        repository.save(reservation);
        return true;

    }

    @Transactional
    public List<ReservationDto> report(ZonedDateTime from, ZonedDateTime to) {
        List<Reservation> reservations = repository.findAll().stream()
                .filter(reservation -> reservation.getDate().isAfter(from))
                .collect(Collectors.toList());
        List<Reservation> reservations1 = reservations.stream()
                .filter(reservation -> reservation.getDate().isBefore(to))
                .collect(Collectors.toList());

        return reservations1.stream()
                .map(reservation -> new ReservationDto().fromEntity(reservation))
                .collect(Collectors.toList());
    }

    public List<ReservationDto> listAll (){

        return repository.findAll().stream()
                .map(reservation -> new ReservationDto().fromEntity(reservation))
                .collect(Collectors.toList());
    }

    public List<ReportDto> reportList(){
        return repository.findAll().stream()
                .map(reservation -> new ReportDto().fromEntity(reservation))
                .collect(Collectors.toList());
    }
}
