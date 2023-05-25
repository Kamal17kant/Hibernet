package com.kamal.table;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Emps {
	@Id
	@Column(name = "emp_id")
	private int empId;

	@Column(name = "emp_name", length = 50)
	private String empName;

	@ManyToMany
	@JoinTable(name = "emp_lern", joinColumns = { @JoinColumn(name = "e_id") }, inverseJoinColumns = {
			@JoinColumn(name = "p_id") })//provide name of the table and column that will created by combining  both table
	private List<Projects> project;

}
