package com.iranna.department_service.repository;

import com.iranna.department_service.entity.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentRepository {


    private List<Department> departments = new ArrayList<>();

    public Department addDepartment(Department department) {
        departments.add(department);
        return department;
    }

    public Department findById(Long id){
        return departments.stream().filter(department -> department.getId() == id).findFirst().orElseThrow();
    }

    public List<Department> findAll(){
        return departments;
    }
}
