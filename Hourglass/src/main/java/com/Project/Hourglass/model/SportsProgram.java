package com.Project.Hourglass.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "sports_program")
@PrimaryKeyJoinColumn(name = "id")
public class SportsProgram extends DayProgram {


}
