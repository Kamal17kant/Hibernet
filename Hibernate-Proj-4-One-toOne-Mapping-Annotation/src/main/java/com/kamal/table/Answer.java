package com.kamal.table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Answer {
	@Id
	@Column(name="answer_id")
	private int answerId;
	
	@Column(length=100)
	private String answer;
}
