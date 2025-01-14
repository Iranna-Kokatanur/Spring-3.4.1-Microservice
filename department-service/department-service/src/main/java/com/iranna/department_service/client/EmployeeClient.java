package com.iranna.department_service.client;

import com.iranna.department_service.entity.Department;
import com.iranna.department_service.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {

    @GetExchange("/employee/department/{id}")
    public List<Employee> findByDepartmentId(@PathVariable Long id);
}
