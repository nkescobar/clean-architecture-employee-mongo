package com.makingapp.employee.mongo.repository;

import com.makingapp.employee.mongo.entities.EmployeeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<EmployeeEntity, String> {
}
