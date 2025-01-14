package com.iranna.employee_service.repository;

import com.iranna.employee_service.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepo {

    private List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee findById(Long id){
        return employees.stream().filter(employee -> employee.id() == id).findFirst().orElseThrow();
    }

    public List<Employee> findAll(){
        return employees;
    }

    public List<Employee> findByDepartmentId(Long id){
        return employees.stream().filter(employee -> employee.departmentId() == id).toList();
    }

}
