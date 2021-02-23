package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.EmpEntityDetails;

public interface EmpRepository extends CrudRepository<EmpEntityDetails, Integer> {

}
