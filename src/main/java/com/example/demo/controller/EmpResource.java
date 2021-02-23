package com.example.demo.controller;

import com.example.demo.Model.EmpEduEntity;
import com.example.demo.Model.EmpEntityDetails;
import com.example.demo.service.EmpService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//https://dzone.com/articles/running-apache-kafka-on-windows-os

@RestController
public class EmpResource {

    @Autowired
    EmpService empService;

    @Autowired
    ObjectMapper objectMapper;


    @RequestMapping(value = "/emp/allRecord", method = RequestMethod.GET)
    public ArrayList<EmpEntityDetails> getAllEmpRecord() {
        return empService.getAllEmpRecord();
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public String createNewEmp(@RequestBody String empRecord) {
//		System.out.print(empRecord);
        JSONObject json = new JSONObject(empRecord);
        System.out.print(json);

        if (!json.isNull("empEduDetails")) {


        }
        empService.createNewEmp(empRecord);
        return "created successfully";
    }

    @RequestMapping(value = "/emp/update", method = RequestMethod.PUT)
    public void updateEmp(@RequestBody EmpEntityDetails empRecord) {
        empService.updateEmp(empRecord);
    }

    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.GET)
    public void getEmpByEmpId(@PathVariable("empId") int empId) {
        empService.getEmpRecordById(empId);
    }

    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.DELETE)
    public void deleteEmpRecord(@PathVariable("empId") int empId) {
        empService.deleteEmp(empId);
    }

    @RequestMapping(value = "/emp/field", method = RequestMethod.GET)
    public String getEmp() {
//		System.out.print("request came here");
        EmpEduEntity ed = new EmpEduEntity();
        ed.setClgName("BLB");
        ed.setDegree("B.com");
        EmpEduEntity ed2 = new EmpEduEntity();
        ed2.setDegree("M.com");
        ed2.setClgName("GYS University");
        List<EmpEduEntity> listData = new ArrayList<EmpEduEntity>();
        listData.add(ed);
        listData.add(ed2);
        EmpEntityDetails emp = new EmpEntityDetails();
        emp.setEmpName("Vinay Parashar");
        emp.setEmpContactno("9098763746");
        emp.setEmpAddress("Aligarh");
        emp.setEmpListData(listData);
//		empService.createNewEmp(emp);
        return "created successfully";
//		return empService.getEmpField();
    }

}
