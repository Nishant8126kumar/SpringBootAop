package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.model.EmpEntityDetails;

public interface EmpService {

    public Map<String, Object> getAllEmpRecord();

    public void createNewEmp(String empRecord);

    public void deleteEmp(int empId);

    public Map<String, Object> updateEmp(EmpEntityDetails empRecord);

    public Map<String, Object> getEmpRecordById(int empId);

    public Map<String, Object> getEmpField();

    public void manyToManyMappings();

    public void manyToOne();

    public void oneToOne();

    public Map<String, Object> getListemp(Map<String, Object> param);

    public <T> Object genericCriteria(T t1, String joinTableName);
    List<Object> getByJoinCriteria();


}
