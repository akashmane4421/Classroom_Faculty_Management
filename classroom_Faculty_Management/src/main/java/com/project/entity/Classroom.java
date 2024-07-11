package com.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String name;
	
	
	public Classroom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classroom(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	

	@Override
	public String toString() {
		return "Classroom [id=" + id + ", name=" + name + "]";
	}
	
	
}
