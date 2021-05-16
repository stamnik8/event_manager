package org.app.event_manager.service;

import org.app.event_manager.dao.model.User;
import org.app.event_manager.dao.repositories.UserRepository;
import org.app.event_manager.web.ExceptionHandlers.BadRequestException;
import org.app.event_manager.web.ExceptionHandlers.ResourceNotFoundException;
import org.app.event_manager.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    private JavaMailSender sender;

    @Transactional
    public UserDto create(UserDto userDto) {
        User user = userDto.toEntity();
        user.setIsAdmin(false);
        repository.save(user);
        userDto.fromEntity(user);

        return userDto;
    }

    @Transactional
    public UserDto findById(UUID id) {
        User user = repository.findByExternalId(id);
        if (user == null) {
            throw new ResourceNotFoundException("No user with id '" + id + "' found");
        }
        UserDto dto = new UserDto().fromEntity(user);

        return dto;
    }

    @Transactional
    public List<UserDto> listAll() {
        List<User> users = repository.findAll();

        return users.stream()
                .map(user -> new UserDto().fromEntity(user))
                .collect(Collectors.toList());
    }

    @Transactional
    public void resetPassword(UUID id) {
        User user = repository.findByExternalId(id);
        if (user == null) {
            throw new ResourceNotFoundException("No user with id '" + id + "' found");
        }
        user.setPassword("defaultpassword");
        user.setForgotPass(false);
        repository.save(user);
    }

    @Transactional
    public UserDto authenticate(String username, String password) {
        User user = repository.findByUsername(username);
        if (user == null) {
            throw new ResourceNotFoundException("No user with username '" + username + "' found");
        }
        if (!user.getPassword().equals(password)) {
            throw new BadRequestException("Wrong  password");
        }
        return new UserDto().fromEntity(user);
    }

    @Transactional
    public void forgotPassword(String username) throws MessagingException {
        User user = repository.findByUsername(username);
        if (user == null) {
            throw new ResourceNotFoundException("No user with username '" + username + "' found");
        }
        String password =  UUID.randomUUID().toString();
        user.setPassword(password);
        user.setForgotPass(true);
        repository.save(user);

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(user.getEmail());
        helper.setText("Your new password is: " + password + "\nhave a nice day!\n\nYour friends at JavaDogs");
        helper.setSubject("New TicketMonster Password");

        sender.send(message);

    }

    @Transactional
    public List<UserDto> getUsersForgotPass() {
        List<User> users = repository.findAll().stream()
                .filter(user -> user.getForgotPass())
                .collect(Collectors.toList());
        return users.stream()
                .map(user -> new UserDto().fromEntity(user))
                .collect(Collectors.toList());
    }

    public void changePassword(UUID id,String oldPass, String newPass) {
        User user = repository.findByExternalId(id);
        if (user == null) {
            throw new ResourceNotFoundException("No user with id '" + id + "' found");
        }
        if(!user.getPassword().equals(oldPass)){
            throw new BadRequestException("Wrong Password");
        }
        user.setPassword(newPass);
        user.setForgotPass(false);
        repository.save(user);
    }
}