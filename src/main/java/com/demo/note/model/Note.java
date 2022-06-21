package com.demo.note.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@NoArgsConstructor
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String value;
	
	public Note(String value) {
		this.value = value;
	}
	
}
