package com.Project.Hourglass.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Hourglass.model.Weightlossprogram;
import com.Project.Hourglass.model.Workout;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout,Long> {
	public List<Workout> findByCoachId(Long id);

	public Optional<Workout> findByName(String m);

    @Query("select w from Workout w where w.coach.id =?1 ")
    List<Workout> findAllByCoachId(Long id);
	public Workout findByIdAndCoachId(Long id, Long coachId);
}
