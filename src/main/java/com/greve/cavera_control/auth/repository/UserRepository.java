package com.greve.cavera_control.auth.repository;

import com.greve.cavera_control.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByUsername(String username);

    Optional<User> findByEmail(String email);

    @Query("SELECT u.id FROM User u WHERE u.email = :identifier OR u.username = :identifier")
    Long findIdByEmailOrUsername(@Param("identifier") String identifier);
}
