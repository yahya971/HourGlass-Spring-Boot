package com.Project.Hourglass.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Hourglass.model.Weightlossprogram;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WeightlossprogramRepository extends JpaRepository<Weightlossprogram,Long> {

    @Query("select p from Weightlossprogram p where  p.coach.id = ?1")
    List<Weightlossprogram> findProgramByCoachId(Long id);
}
