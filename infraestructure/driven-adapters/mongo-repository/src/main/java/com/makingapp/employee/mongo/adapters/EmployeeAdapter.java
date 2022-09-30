package com.makingapp.employee.mongo.adapters;

import com.makingapp.employee.model.Employee;
import com.makingapp.employee.mongo.entities.EmployeeEntity;
import com.makingapp.employee.mongo.mapper.EmployeeMapper;
import com.makingapp.employee.mongo.repository.EmployeeRepository;
import com.makingapp.employee.service.EmployeeService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAdapter implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);

    public EmployeeAdapter(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> find() {
        return this.employeeMapper.listEntityToModel(
                employeeRepository.findAll());
    }

    @Override
    public Employee findById(String id) {
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return this.employeeMapper.toModel(employee.get());
        }
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        return this.employeeMapper.toModel(employeeRepository.save(this.employeeMapper.toEntity(employee)));
    }

    @Override
    public void delete(String id) {
        this.employeeRepository.deleteById(id);
    }
}
