package com.example.demo.controller;


import com.example.demo.model.HiberCompany;
import com.example.demo.model.HiberCompanyDetails;
import com.example.demo.repository.HiberCompanyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HibernateExampleCotroller {

    @Autowired
    HiberCompanyRepository hiberCompanyRepository;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping(value = "/map")
    public ResponseEntity<?> hiberDemo(@RequestBody String hiberCompanyObj) throws JsonProcessingException {
        Map response = new HashMap();
        List<HiberCompany> listdata = new ArrayList<HiberCompany>();
        HiberCompany hiberCompany = objectMapper.readValue(hiberCompanyObj, HiberCompany.class);
        HiberCompany hb = new HiberCompany();
        hb.setName("Fretron");
        HiberCompanyDetails hbD = new HiberCompanyDetails();
        hbD.setName("Owner");
        hb.setHiberCompanyDetails(hbD);
        hiberCompanyRepository.save(hb);
        System.out.println(hiberCompany);
        hiberCompanyRepository.findAll().forEach(it -> listdata.add(it));
        response.put("data", listdata);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
