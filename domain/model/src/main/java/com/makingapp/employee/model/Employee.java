package com.makingapp.employee.model;

import lombok.Data;

@Data
public class Employee {
    private String id;
    private String name;
    private String lastName;
    private int age;
    private String address;
    private String phone;
}
