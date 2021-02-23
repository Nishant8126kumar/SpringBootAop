package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class EmpEntityDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@Column
	String empName;

	@Column
	String empAddress;

	@Column
	String empContactno;

	@Column
	String empDesignation;

//	@OneToOne(cascade = { CascadeType.ALL })
//	private EmpEduEntity empEduDetails;

	@OneToMany
	private List<EmpEduEntity> empListData = new ArrayList<EmpEduEntity>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpContactno() {
		return empContactno;
	}

	public void setEmpContactno(String empContactno) {
		this.empContactno = empContactno;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public List<EmpEduEntity> getEmpListData() {
		return empListData;
	}

	public void setEmpListData(List<EmpEduEntity> empListData) {
		this.empListData = empListData;
	}

	@Override
	public String toString() {
		return "EmpEntityDetails [id=" + id + ", empName=" + empName + ", empAddress=" + empAddress + ", empContactno="
				+ empContactno + ", empDesignation=" + empDesignation + ", empListData=" + empListData + "]";
	}

	public EmpEntityDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
