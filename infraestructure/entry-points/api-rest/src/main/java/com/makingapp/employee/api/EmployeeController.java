package com.makingapp.employee.api;

import com.makingapp.employee.model.Employee;
import com.makingapp.employee.response.model.CustomResponse;
import com.makingapp.employee.service.EmployeeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
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

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("list", employeeService.find());
        return "index";

    }

    @PostMapping("/guardar")
    public String save(Employee empleado, Model model) {

        employeeService.save(empleado);
        return "redirect:/";
    }

    @GetMapping("/guardar/{id}")
    public String showSave(@PathVariable("id") String id, Model model) {

        if (id != null && !"0".equals(id)) {
            model.addAttribute("empleado", employeeService.findById(id));
        } else {
            model.addAttribute("empleado", new Employee());
        }

        return "guardar";

    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        employeeService.delete(id);
        return "redirect:/";
    }


}
