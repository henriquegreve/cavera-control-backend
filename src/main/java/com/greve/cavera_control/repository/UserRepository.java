package com.greve.cavera_control.repository;

import com.greve.cavera_control.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByUsername(String username);

    Optional<User> findByEmail(String email);
}
