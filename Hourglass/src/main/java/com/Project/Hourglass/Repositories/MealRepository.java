package com.Project.Hourglass.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Hourglass.model.Meal;

public interface MealRepository extends JpaRepository<Meal,Long> {
	public Meal findByIdAndCoachId(Long id,Long coachId);
}
