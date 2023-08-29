package com.example.jpaexistsbug.model;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
abstract public class Thing {
	@Id
	private Long id;

	public Thing() {
	}

	public Thing(Long id) {
		this.id = id;
	}
}
