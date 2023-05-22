package com.kamal.table;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Certificate {
	@Column(length = 20)
	private String course;
	@Column(length=20)
	private String duration;
}
