package com.example.demo.repository;

import com.example.demo.model.HiberCompany;
import org.springframework.data.repository.CrudRepository;

public interface HiberCompanyRepository extends CrudRepository<HiberCompany, Integer> {
}
