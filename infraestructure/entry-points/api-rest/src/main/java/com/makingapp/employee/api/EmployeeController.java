package com.makingapp.employee.api;

import com.makingapp.employee.model.Employee;
import com.makingapp.employee.response.model.CustomResponse;
import com.makingapp.employee.service.EmployeeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin
public class EmployeeController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public ResponseEntity<CustomResponse<List<Employee>>> find() {
        return employeeService.find();
    }

    @PostMapping("/employee")
    public ResponseEntity<CustomResponse<Employee>> saveCategory(@RequestBody Employee request) {
        return employeeService.save(request);
    }


}
