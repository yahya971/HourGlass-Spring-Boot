package com.Project.Hourglass.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Hourglass.model.Workout;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout,Long> {

    @Query("select w from Workout w where w.coach.id =?1 ")
    List<Workout> findAllByCoachId(Long id);
}
