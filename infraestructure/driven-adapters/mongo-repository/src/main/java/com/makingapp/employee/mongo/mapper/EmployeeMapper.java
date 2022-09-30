package com.makingapp.employee.mongo.mapper;

import com.makingapp.employee.model.Employee;
import com.makingapp.employee.mongo.entities.EmployeeEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface EmployeeMapper {

    Employee toModel(EmployeeEntity employeeEntity);

    EmployeeEntity toEntity(Employee employee);


    default List<EmployeeEntity> listModelToEntity(List<Employee> employees) {
        return employees.stream().map(this::toEntity).collect(Collectors.toList());
    }

    default List<Employee> listEntityToModel(
            List<EmployeeEntity> categoryEntities) {
        return categoryEntities.stream().map(this::toModel).collect(Collectors.toList());
    }
}
