package com.example.demo;

import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	private int id;
	private String name;
	private String dept;
	private Set<String> description;
	
	public Employee() {
	
	}

	public Set<String> getDescription() {
		return description;
	}

	public void setDescription(Set<String> description) {
		this.description = description;
	}

	public int getId() {
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", description=" + description + "]";
	}

	
	

}
