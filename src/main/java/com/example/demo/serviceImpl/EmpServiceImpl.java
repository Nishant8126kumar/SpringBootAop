package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.EmpEduEntity;
import com.example.demo.Model.EmpEntityDetails;
import com.example.demo.dto.EmpDto;
import com.example.demo.repository.EmpRepository;
import com.example.demo.service.EmpService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpRepository empRepository;

	@Autowired
	ObjectMapper mapper;

	@Override
	public ArrayList<EmpEntityDetails> getAllEmpRecord() {
		ArrayList<EmpEntityDetails> empList = new ArrayList<EmpEntityDetails>();
		empRepository.findAll().forEach(e -> empList.add(e));
		return empList;
	}

	@Override
	public void createNewEmp(String empRecord) {
		try {
			JSONObject json = new JSONObject(empRecord);
			EmpEntityDetails empDetails = new EmpEntityDetails();
			EmpEduEntity empEducationdetails = new EmpEduEntity();
			List<EmpEduEntity> eduList = new ArrayList<EmpEduEntity>();
			System.out.print(json);

			if (!json.isNull("empEduDetails")) {
				JSONArray jsonArray = new JSONArray(json.get("empEduDetails"));
				for (int i = 0; i < jsonArray.length()-1; i++) {
					empEducationdetails = mapper.readValue(jsonArray.getJSONObject(i).toString(), EmpEduEntity.class);
					eduList.add(empEducationdetails);
				}
			}
			empDetails = mapper.readValue(empRecord, EmpEntityDetails.class);
			empDetails.setEmpListData(eduList);
			System.out.print(empDetails);
//			empRepository.save(empDetails);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	@Override
	public void deleteEmp(int empId) {
		empRepository.deleteById(empId);
	}

	@Override
	public void updateEmp(EmpEntityDetails empRecord) {
		empRepository.save(empRecord);
	}

	@Override
	public EmpEntityDetails getEmpRecordById(int empId) {
		return (EmpEntityDetails) empRepository.findById(empId).get();
	}

	@Override
	public ArrayList<EmpDto> getEmpField() {
		ArrayList<EmpDto> dtoList = new ArrayList<EmpDto>();
		empRepository.findAll().forEach(it -> {
			EmpDto emp = new EmpDto();
			emp.setId(it.getId());
			emp.setName(it.getEmpName());
			dtoList.add(emp);
		});
		return dtoList;
	}

}
