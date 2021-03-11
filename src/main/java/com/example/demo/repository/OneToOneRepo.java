package com.example.demo.repository;

import com.example.demo.model.OneToOneEmp;
import org.springframework.data.repository.CrudRepository;

public interface OneToOneRepo extends CrudRepository<OneToOneEmp, Integer> {
}
