package com.employees.employeesdb.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.employeesdb.entity.EmployeeEntity;
import com.employees.employeesdb.services.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@Api(value = "Employees Management System", tags = "Employees")
@RequestMapping("/api/employees")
public class Employees {

    @Autowired
    private EmployeeService employeesService;


    @GetMapping
    @ApiOperation(value = "Get all employees", response = List.class)
    public List<EmployeeEntity>getAllEmployees(){
        return this.employeesService.getAllEmployees();
    }
    
    @ApiOperation(value = "Get employee by ID", response = EmployeeEntity.class)
    @GetMapping("/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable ObjectId id) {
        return this.employeesService.getEmployeeById(id);
    }
    
    //to get all employees

    //Post to create employees
    @PostMapping
    @ApiOperation(value = "Create a new employee")
    public void createEmployee(@RequestBody EmployeeEntity employee){
        this.employeesService.createEmployee(employee);
    }

    //to put all
    @ApiOperation(value = "Update an employee by username")
    @PutMapping("/{userName}")
    public ResponseEntity<?>updateEmployee(@RequestBody EmployeeEntity employee,@PathVariable String userName){
        EmployeeEntity employeeInDb=employeesService.findByUserName(userName);
        if(employeeInDb!=null){
            employeeInDb.setName(employeeInDb.getName());
            employeeInDb.setEmail(employeeInDb.getEmail());
            employeeInDb.setPosition(employeeInDb.getPosition());
            employeeInDb.setDepartment(employeeInDb.getDepartment());
            employeesService.createEmployee(employeeInDb);

        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    

    @ApiOperation(value = "Delete an employee by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployees(@PathVariable ObjectId id){
        this.employeesService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
    }
}
