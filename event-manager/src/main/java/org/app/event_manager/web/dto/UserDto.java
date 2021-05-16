package org.app.event_manager.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.app.event_manager.dao.model.User;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class UserDto implements Serializable {

    private UUID id;

    @ApiModelProperty(value = "hello")
    @NotNull
    private String username;

    @ApiModelProperty
    @NotNull
    private String password;

    @ApiModelProperty
    private String firstName;

    @ApiModelProperty
    private String lastName;

    private Boolean isAdmin;

    @ApiModelProperty(example = "test@testing.com")
    @NotNull
    private String email;

    private Boolean forgotPassword;

    public UserDto() {
    }

    public UserDto(UUID id, String username, String password, String firstName, String lastName, String email, Boolean forgotPassword,Boolean admin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.forgotPassword = forgotPassword;
        this.isAdmin = admin;
    }

    public UserDto fromEntity(User user){
        setId(user.getExternalId());
        setUsername(user.getUsername());
        setPassword(user.getPassword());
        setEmail(user.getEmail());
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setForgotPassword(user.getForgotPass());
        setIsAdmin(user.getIsAdmin());

        return this;
    }

    public User toEntity(){
        User user = new User();

        return this.toEntity(user);
    }

    public User toEntity(User user) {

        user.setUsername(getUsername());
        user.setPassword(getPassword());
        user.setFirstName(getFirstName());
        user.setLastName(getLastName());
        user.setEmail(getEmail());
        user.setForgotPass(getForgotPassword());
        user.setIsAdmin(getIsAdmin());

        return user;
    }


}

