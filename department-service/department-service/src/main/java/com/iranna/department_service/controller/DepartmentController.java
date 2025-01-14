package com.iranna.department_service.controller;

import com.iranna.department_service.client.EmployeeClient;
import com.iranna.department_service.entity.Department;
import com.iranna.department_service.entity.Employee;
import com.iranna.department_service.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);

    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department){
        LOGGER.info("Department add: {}", department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll(){
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
        LOGGER.info("Department find: id={}", id);
        return departmentRepository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees(){
        List<Department> departments = departmentRepository.findAll();
        departments.forEach(department -> department.setEmployees(employeeClient.findByDepartmentId(department.getId())));
        return departments;
    }

}
