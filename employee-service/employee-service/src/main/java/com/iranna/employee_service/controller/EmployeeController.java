package com.iranna.employee_service.controller;

import com.iranna.employee_service.entity.Employee;
import com.iranna.employee_service.repository.EmployeeRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeRepo employeeRepository;

    public EmployeeController(EmployeeRepo employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee){

        employeeRepository.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        LOGGER.info("Employee find: id={}", id);
         return employeeRepository.findById(id);
    }

    @GetMapping("/department/{id}")
    public List<Employee> findByDepartmentId(@PathVariable Long id){
        LOGGER.info("Employee find: departmentId={}", id);
        return employeeRepository.findByDepartmentId(id);
    }


}
