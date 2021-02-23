package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.Model.EmpEntityDetails;
import com.example.demo.dto.EmpDto;

public interface EmpService {

	public ArrayList<EmpEntityDetails> getAllEmpRecord();

	public void createNewEmp(String empRecord);

	public void deleteEmp(int empId);

	public void updateEmp(EmpEntityDetails empRecord);

	public EmpEntityDetails getEmpRecordById(int empId);

	public ArrayList<EmpDto> getEmpField();

}
