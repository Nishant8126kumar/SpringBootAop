package com.example.demo.repository;

import com.example.demo.model.Emp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpAccountDetailsRepository extends CrudRepository<Emp, Integer> {
}
