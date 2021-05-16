package org.app.event_manager.web.ExceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TicketBalanceException extends RuntimeException{
    public TicketBalanceException(String msg){
        super(msg);
    }
}
