package com.makingapp.employee.service;

import com.makingapp.employee.model.Employee;

import java.util.List;

public interface EmployeeService  {
    List<Employee> find();
    Employee findById(String id);
    Employee save(Employee employee);
    void delete(String id);
}
