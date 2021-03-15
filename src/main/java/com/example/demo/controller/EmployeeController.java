package com.example.demo.controller;

import com.example.demo.exception.MainException;
import com.example.demo.model.Emp;
import com.example.demo.model.EmpAccount;
import com.example.demo.model.EmpEntityDetails;
import com.example.demo.repository.EmpRepository;
import com.example.demo.service.EmpService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//https://dzone.com/articles/running-apache-kafka-on-windows-os

@RestController
public class EmployeeController {

    @Autowired
    EmpService empService;

    @Autowired
    EmpRepository empRepository;

    @Autowired
    EntityManager entityManager;

    ModelMapper modelMapper = new ModelMapper();

    @PostMapping(value = "/emp", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createNewEmp(@RequestBody String empRecord) throws MainException {
        empService.createNewEmp(empRecord);
        return new ResponseEntity<Map<String, Object>>(HttpStatus.CREATED);
    }


    @PutMapping(value = "/emp/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateEmp(@RequestBody EmpEntityDetails empRecord) {
        return new ResponseEntity<Map<String, Object>>(empService.updateEmp(empRecord), HttpStatus.OK);
    }

    @GetMapping(value = "/emp/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEmpByEmpId(@PathVariable("empId") int empId) {
        return new ResponseEntity<Map<String, Object>>(empService.getEmpRecordById(empId), HttpStatus.OK);
    }

    @GetMapping(value = "/emp/allRecord", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllEmpRecord() {
        return new ResponseEntity<Map<String, Object>>(empService.getAllEmpRecord(), HttpStatus.OK);
    }

    @GetMapping(value = "/emp/field", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEmp() {
        return new ResponseEntity<Map<String, Object>>(empService.getEmpField(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/emp/{empId}")
    public void deleteEmpRecord(@PathVariable("empId") int empId) {
        empService.deleteEmp(empId);
    }

    //Example of  Hibernate Mapping

    @PostMapping(value = "/emp/oneToOne")
    public String oneToOne() {
        System.out.println("request came here");
        empService.oneToOne();
        return "request created successfully oneToOne Mapping";
    }

    @PostMapping(value = "/emp/manyToOne")
    public String manyToOne() {
        empService.manyToOne();
        return "request created succesfully manyToOne Mapping";
    }

    @PostMapping(value = "/emp/manyTomany")
    public String manyToMany() {
        empService.manyToManyMappings();
        return "request created successfully manyToMany";
    }

    @GetMapping("/custom")
    public ResponseEntity<?> createCustomQuery() {
        List<EmpEntityDetails> empDetails = empRepository.findByEmpAddress("Deepesh dixit", "Noida");
        return new ResponseEntity<>(empDetails, HttpStatus.OK);
    }

    @GetMapping("/custom/between")
    public ResponseEntity<List<EmpEntityDetails>> createBetWeencustomwuery() {
        List<EmpEntityDetails> empEntityDetails = empRepository.findDataUsingBetween(2, 13);
        return new ResponseEntity<>(empEntityDetails, HttpStatus.OK);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getListdEmp(@RequestParam Map<String, Object> request) throws JsonProcessingException {
        System.out.println("request came here");
        return ResponseEntity.ok(empService.getListemp(request));
    }

    @GetMapping(value = "/jpql/{empId}")
    public ResponseEntity<?> getEmpData(@PathVariable("empId") int empId) {
        List list = empRepository.getEmp().stream().map(EmpEntityDetails::getEmpName).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }


    @GetMapping("/join")
    public ResponseEntity<?> joinPractise() {
        List empDetails = empRepository.applyJoin();
        return new ResponseEntity<>(empDetails, HttpStatus.OK);
    }

    @GetMapping(value = "/generic/creteria")
    public ResponseEntity<?> creteriaGeneric() {
        return ResponseEntity.ok(empService.genericCriteria(new Emp(), "empAccountDetailsList"));

    }

    @GetMapping(value = "/join/creteria")
    public ResponseEntity<?> creteriaJoin() {

        List list = null;
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Emp> criteriaQuery = criteriaBuilder.createQuery(Emp.class);
            Root<Emp> root = criteriaQuery.from(Emp.class);
            Join<Emp, EmpAccount> item = root.join("empAccountDetailsList", JoinType.LEFT);
            criteriaQuery.multiselect(root.get("empName"), item.get("bankName"));
//            TypedQuery<Emp> query = entityManager.createQuery(criteriaQuery);
//            System.out.println(query);
//            list = query.getResultList();
//            System.out.println(list);
            System.out.println(empService.genericCriteria(new Emp(), "empAccountDetailsList"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/multi/join")
    public ResponseEntity<?> multipleJoin() {
        return ResponseEntity.ok(empRepository.getMultipleTableJoin());
    }

    @GetMapping(value = "/join/table")
    public ResponseEntity<?> siglejoinData() {
        return ResponseEntity.ok(empService.getByJoinCriteria());

    }
}
