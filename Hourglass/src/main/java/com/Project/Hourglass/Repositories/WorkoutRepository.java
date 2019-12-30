package com.Project.Hourglass.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Hourglass.model.Workout;

public interface WorkoutRepository extends JpaRepository<Workout,Long> {
	public List<Workout> findByCoachId(Long id);
}
