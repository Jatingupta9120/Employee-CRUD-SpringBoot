package com.employees.employeesdb.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;


@Document(collection="employees")
@Data
public class EmployeeEntity {

    @Id()
    private ObjectId id;

    private String name;

    // @Indexed(unique = true) 
    // @NonNull
    private String userName;

    // @NonNull
    private String email;

    private String position;

    private String department;

}
