package com.Project.Hourglass.Repositories;

import com.Project.Hourglass.model.Role;
import com.Project.Hourglass.model.enumeration.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName name);
}
