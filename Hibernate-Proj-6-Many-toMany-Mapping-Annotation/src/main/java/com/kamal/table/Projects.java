package com.kamal.table;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Projects {
	@Id
	@Column(name="proj_id")
	private int projId;
	
	@Column(name="proj_name",length=50)
	private String projName;
	
	@ManyToMany(mappedBy="project")
	private List<Emps> employ;
}
