package com.kamal.table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	private int id;
	@Column(name="sname",length=30)
	private String name;
	@Column(name="scity",length=30)
	private String city;
	private Certificate certi;
}
