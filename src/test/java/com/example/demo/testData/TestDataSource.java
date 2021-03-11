package com.example.demo.testData;

import com.example.demo.model.EmpEntityDetails;

import java.util.ArrayList;

public class TestDataSource {


    public ArrayList<EmpEntityDetails> getDataForTest() {
        EmpEntityDetails empEntityDetails = new EmpEntityDetails();
        ArrayList<EmpEntityDetails> listFakeData = new ArrayList<EmpEntityDetails>();
        empEntityDetails.setEmpName("testName");
        empEntityDetails.setEmpAddress("testAddress");
        empEntityDetails.setEmpContactno("273479");
        empEntityDetails.setEmpDesignation("testDeveloper");
        listFakeData.add(empEntityDetails);
        return listFakeData;
    }
}



