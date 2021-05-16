package org.app.event_manager.web.controllers;

import io.swagger.annotations.ApiOperation;

import org.app.event_manager.service.ReservationService;
import org.app.event_manager.service.UserService;
import org.app.event_manager.web.dto.ReportDto;
import org.app.event_manager.web.dto.UserDto;
import org.app.event_manager.web.validators.GeneralValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    GeneralValidator validator;

    @Autowired
    ReservationService reservationService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Creates a new user")
    public UserDto create(@Valid @RequestBody UserDto dto){
        validator.validateUser(dto);
        return service.create(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the user with the specified Id")
    public UserDto list(@PathVariable UUID id){
        return service.findById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "Returns all users")
    public List<UserDto> listAll() {return service.listAll();}


    @RequestMapping(value = "/forgotReport", method = RequestMethod.GET)
    @ApiOperation(value = "Returns all users who have forgot their password")
    public List<UserDto> listForgPass() {return service.getUsersForgotPass();}

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Resets a user's password to a default value")
    public void resetPassword(@PathVariable UUID id) {
        service.resetPassword(id);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ApiOperation(value = "Authenticates a username and password")
    public UserDto authenticate(@RequestParam String username, @RequestParam String password){
        validator.validate(username);
        validator.validate(password);
        return service.authenticate(username, password);
    }

    @RequestMapping(value = "/{username}/forgot", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Set the forgotPass variable")
    public void forgotPassword(@PathVariable String username) throws MessagingException {
        validator.validate(username);
        service.forgotPassword(username);
    }

    @RequestMapping(value = "/{id}/reservations", method = RequestMethod.GET)
    @ApiOperation(value = "returns all the user's reservations")
    public List<ReportDto> listUserReservation(@PathVariable UUID id){
        return reservationService.findByUser(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Change password")
    public void changePassword(@PathVariable UUID id,@RequestParam String oldPass, @RequestParam String newPass) throws MessagingException {
        validator.validate(id);
        validator.validate(newPass);
        validator.validateUserPass("user", newPass);
        service.changePassword(id,oldPass, newPass);
    }

}
