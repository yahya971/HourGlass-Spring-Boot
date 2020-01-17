package com.Project.Hourglass.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Project.Hourglass.model.Dayprogram;
import com.Project.Hourglass.model.Nutritionalprogram;

public interface NutritionalprogramRepository extends JpaRepository<Nutritionalprogram,Long> {
	 @Query("select p from Dayprogram p where  p.weightlossprogram.id = ?1 and p.id in(select m.id from Nutritionalprogram m )")
	List<Nutritionalprogram> findNutritionalprogamByWeightlossprogramId(Long id);

	 @Query("select p from Dayprogram p where p.weightlossprogram.id = ?1 and p.day = ?2 and p.id in (select m.id from Nutritionalprogram m)")
	 Nutritionalprogram findNutritionalprogramByWeightLossProgramAndAndDay(Long id, String day);
}


