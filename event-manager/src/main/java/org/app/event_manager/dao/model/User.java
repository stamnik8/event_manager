package org.app.event_manager.dao.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "User")
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Type(type = "uuid-char")
    private UUID externalId;


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
    private Set<Reservation> reservations;


    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean isAdmin;
    private Boolean forgotPass;

    public User(){
        this.externalId = UUID.randomUUID();
        this.forgotPass = false;
    }
}