package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmpEduEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "empId")
	private int empId;

	@Column
	private String degree;

	@Column
	private String clgName;

	public EmpEduEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpEduEntity(int empId, String degree, String clgName) {
		super();
		this.empId = empId;
		this.degree = degree;
		this.clgName = clgName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getClgName() {
		return clgName;
	}

	public void setClgName(String clgName) {
		this.clgName = clgName;
	}

	@Override
	public String toString() {
		return "EmpEduEntity [empId=" + empId + ", degree=" + degree + ", clgName=" + clgName + "]";
	}

}
