package com.Project.Hourglass.Repositories;

import com.Project.Hourglass.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Long> {
}
