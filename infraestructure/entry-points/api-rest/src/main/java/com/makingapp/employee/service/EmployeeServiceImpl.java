package com.makingapp.employee.service;

import com.makingapp.employee.model.Employee;
import com.makingapp.employee.response.model.CustomResponse;
import com.makingapp.employee.usecase.EmployeeUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl {

    private final EmployeeUseCase employeeUseCase;

    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    public EmployeeServiceImpl(EmployeeUseCase employeeUseCase) {
        this.employeeUseCase = employeeUseCase;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<CustomResponse<List<Employee>>> find() {
        CustomResponse<List<Employee>> response = new CustomResponse();
        try {
            List<Employee> employees = employeeUseCase.find();
            response.setResponse(employees);
            response.setMessage("Respuesta exitosa.");
        } catch (Exception e) {
            response.setMessage("Error al consultar los empleados");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            log.error("Error al consultar los empleados", e.getMessage());
            e.getStackTrace();
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.setStatus(HttpStatus.OK);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<CustomResponse<Employee>> findById(String id) {
        CustomResponse<Employee> response = new CustomResponse();
        try {
            Employee employee = employeeUseCase.findById(id);
            response.setResponse(employee);
            response.setMessage("Respuesta exitosa.");
        } catch (Exception e) {
            response.setMessage("Error al consultar el empleado");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            log.error("Error al consultar el empleado", e.getMessage());
            e.getStackTrace();
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.setStatus(HttpStatus.OK);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<CustomResponse<Employee>> save(Employee category) {
        CustomResponse<Employee> response = new CustomResponse();
        try {
            Employee categoryResponse = employeeUseCase.save(category);
            response.setResponse(categoryResponse);
            response.setMessage("Respuesta exitosa.");
        } catch (Exception e) {
            response.setMessage("Error al guardar el empleado");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            log.error("Error al guardar el empleaado", e.getMessage());
            e.getStackTrace();
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.setStatus(HttpStatus.OK);
        return new ResponseEntity(response, HttpStatus.OK);
    }


    @Transactional
    public ResponseEntity<CustomResponse> delete(String id) {
        CustomResponse response = new CustomResponse();
        try {
            employeeUseCase.delete(id);
            response.setMessage("Registro eliminado.");
        } catch (Exception e) {
            response.setMessage("Error al eliminar la categoria");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            log.error("Error al eliminar categorias", e.getMessage());
            e.getStackTrace();
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.setStatus(HttpStatus.OK);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
