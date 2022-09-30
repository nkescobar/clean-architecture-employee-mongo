package com.makingapp.employee.mongo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "employee")
public class EmployeeEntity {
    @Id
    private String id;
    private String name;
    private String lastName;
    private int age;
    private String address;
    private String phone;


}
