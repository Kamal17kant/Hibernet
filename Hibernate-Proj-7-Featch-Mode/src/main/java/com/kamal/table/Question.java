package com.kamal.table;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Question {
	@Id
	@Column(name = "Question_id")
	private int questionId;
	
	@Column(length = 80)
	private String question;
	
	@OneToMany(mappedBy="question",fetch = FetchType.EAGER) 
	private List<Answer> answer;
}
