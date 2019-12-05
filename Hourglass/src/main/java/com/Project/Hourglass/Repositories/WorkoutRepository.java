package com.Project.Hourglass.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Hourglass.model.Workout;

public interface WorkoutRepository extends JpaRepository<Workout,Long> {

}
