package com.Project.Hourglass.Repositories;

import com.Project.Hourglass.model.Coach;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CoachRepository extends JpaRepository<Coach,Long> {
    Optional<Coach> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
