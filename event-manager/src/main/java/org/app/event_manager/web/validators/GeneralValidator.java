package org.app.event_manager.web.validators;

import org.app.event_manager.dao.model.User;
import org.app.event_manager.dao.repositories.UserRepository;
import org.app.event_manager.web.ExceptionHandlers.BadRequestException;
import org.app.event_manager.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeneralValidator {

    @Autowired
    UserRepository repository;

    String regex = "^[a-zA-Z0-9]+[_-]+[a-zA-Z0-9]+|[a-zA-Z0-9]+$";

    String regexEmail = "([\\w.-]+@([\\w-]+)\\.+\\w{2,})";

    public void validate(Object resource){
        if(resource == null){
            throw new BadRequestException("Null request");
        }
    }

    public void validateUser(UserDto user){
        validate(user);
        if(user.getUsername() == null){
            throw new BadRequestException("Null username");
        }else if(user.getPassword() == null){
            throw new BadRequestException("Null password");
        }else if(user.getEmail() == null){
            throw new BadRequestException("Null Email");
        }else if(!user.getEmail().matches(regexEmail)){
            throw new BadRequestException("Not valid Email");
        }
        validateUserPass(user.getUsername(),user.getPassword());
        validateUniqueName(user.getUsername());
    }

    public void validateUniqueName(String username){
        User user = repository.findByUsername(username);
        if(user != null){
            throw new BadRequestException("user '" + username + "' already exists");
        }
    }

    public void validateUserPass(String username, String password){
        if(!username.matches(regex)) {
            throw new BadRequestException("Illegal character in username");
        }
        if(!password.matches(regex)) {
            throw new BadRequestException("Illegal character in password");
        }
    }
}