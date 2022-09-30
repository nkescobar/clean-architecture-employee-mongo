package com.makingapp.employee.usecase;

import com.makingapp.employee.model.Employee;
import com.makingapp.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeUseCase {
    private final EmployeeService employeeService;

    public EmployeeUseCase(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> find() {
        return this.employeeService.find();
    }
    public Employee findById(String id) {
        return this.employeeService.findById(id);
    }
    public Employee save(Employee employee) {
        return this.employeeService.save(employee);
    }
    public void delete(String id) {
        this.employeeService.delete(id);
    }

}
