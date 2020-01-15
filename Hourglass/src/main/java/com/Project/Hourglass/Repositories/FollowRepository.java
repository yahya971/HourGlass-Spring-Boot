package com.Project.Hourglass.Repositories;

import com.Project.Hourglass.model.Follow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FollowRepository extends JpaRepository<Follow,Long> {

    @Query("select f from Follow f where f.weightLossProgram.id = ?1")
    List<Follow> findAllByWeightLossProgram(Long id);

    @Query("select f from Follow f where f.weightLossProgram.id = ?1 and f.day = ?2")
    Follow findByWeightLossProgramAndAndDay(Long id, String day);
}
