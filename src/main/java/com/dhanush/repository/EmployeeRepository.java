package com.dhanush.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.dhanush.model.Employee;

@Repository
//spring stereotype ->create bean
public interface EmployeeRepository extends MongoRepository<Employee,String>{
//entity,entity type
}
