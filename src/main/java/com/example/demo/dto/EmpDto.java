package com.example.demo.dto;

public class EmpDto {
	
	private int id;
	private String name;
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
	public EmpDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public EmpDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmpDto [id=" + id + ", name=" + name + "]";
	}

}
