package com.example.jpaexistsbug.model;

import jakarta.persistence.Entity;

@Entity
public class Owner extends Thing {

	private Boolean alive;

	public Owner() {
	}

	public Boolean getAlive() {
		return alive;
	}

	public void setAlive(Boolean alive) {
		this.alive = alive;
	}
}
