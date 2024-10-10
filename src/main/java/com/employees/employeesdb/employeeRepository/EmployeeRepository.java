package com.employees.employeesdb.employeeRepository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.employees.employeesdb.entity.EmployeeEntity;
import java.util.List;


public interface EmployeeRepository extends MongoRepository<EmployeeEntity, ObjectId> {

    // custom query methods here
    EmployeeEntity findByUserName(String userName); 
}
