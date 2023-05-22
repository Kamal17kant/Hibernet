package com.kamal.table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Question {
	@Id
	@Column(name = "Question_id")
	private int questionId;
	
	@Column(length = 80)
	private String question;
	
	@OneToOne
	private Answer answer;
}
