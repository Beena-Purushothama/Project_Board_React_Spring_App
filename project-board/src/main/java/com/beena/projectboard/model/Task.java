package com.beena.projectboard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Required;

import lombok.Data;

@Data
@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Summary cannot be blank")
	private String summary;
	private String acceptanceCriteria;
	private String status;


}
