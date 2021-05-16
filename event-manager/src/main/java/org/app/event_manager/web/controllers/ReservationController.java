package org.app.event_manager.web.controllers;

import io.swagger.annotations.ApiOperation;

import org.app.event_manager.service.ReservationService;
import org.app.event_manager.web.dto.ReportDto;
import org.app.event_manager.web.dto.ReservationDto;
import org.app.event_manager.web.validators.GeneralValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("reservations")
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    ReservationService service;
    @Autowired
    GeneralValidator validator;

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    @ApiOperation(value = "Returns all Reservations")
//    public List<ReservationDto> listAll (){
//        return service.listAll();
//    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "Returns all Reservations")
    public List<ReportDto> listAll(){
        return service.reportList();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Creates a Reservation")
    public ReservationDto create(@RequestBody ReservationDto reservationDto){
        return service.create(reservationDto);
    }

    @RequestMapping(value = "/{reservationId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Canceled Reservation")
    public void cancelReservation (@PathVariable UUID reservationId){
        service.cancel(reservationId);
    }

    @RequestMapping(value = "/{reservationId}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns Reservations By ID")
    public ReservationDto findById(@PathVariable UUID reservationId){
        return service.findById(reservationId);
    }

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    @ApiOperation(value = "Report Reservations")
    public List<ReservationDto> report (@RequestParam ZonedDateTime from , @RequestParam ZonedDateTime to){
        return service.report(from, to);
    }
}
