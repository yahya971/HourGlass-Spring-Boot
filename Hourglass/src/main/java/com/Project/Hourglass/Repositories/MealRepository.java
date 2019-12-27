package com.Project.Hourglass.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Hourglass.model.Meal;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal,Long> {

    @Query("select m from Meal m where m.coach.id =?1 ")
    List<Meal> findAllByCoachId(Long id);

	public Meal findByIdAndCoachId(Long id,Long coachId);

}
