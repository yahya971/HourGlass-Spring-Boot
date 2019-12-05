package com.Project.Hourglass.Repositories;

import com.Project.Hourglass.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
