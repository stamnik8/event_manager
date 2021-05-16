package org.app.event_manager.dao.repositories;

import org.app.event_manager.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByExternalId(UUID id);

}