package com.employees.employeesdb.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employees.employeesdb.employeeRepository.EmployeeRepository;
import com.employees.employeesdb.entity.EmployeeEntity;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeesRepository;

    public void createEmployee(EmployeeEntity employee) {
        employeesRepository.save(employee);
    }

    public List<EmployeeEntity>getAllEmployees(){
        return employeesRepository.findAll();
    }

    public Optional<EmployeeEntity>findEmployeeById(ObjectId id){
        return employeesRepository.findById(id);
    }

    public void deleteUserById(ObjectId id){
        employeesRepository.deleteById(id);
    }

    public EmployeeEntity findByUserName(String userName){
        return employeesRepository.findByUserName(userName);
    }

    public EmployeeEntity getEmployeeById(ObjectId id){
        return employeesRepository.findById(id).orElse(null);
    }
}
