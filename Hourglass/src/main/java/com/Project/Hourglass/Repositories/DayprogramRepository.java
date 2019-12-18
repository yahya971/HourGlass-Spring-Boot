package com.Project.Hourglass.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Hourglass.model.Dayprogram;

public interface DayprogramRepository extends JpaRepository<Dayprogram,Long>{
	 List<Dayprogram> findDayprogramByWeightlossprogramId(Long id);

}
