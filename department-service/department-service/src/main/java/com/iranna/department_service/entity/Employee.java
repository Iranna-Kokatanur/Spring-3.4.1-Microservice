package com.iranna.department_service.entity;

public record Employee(Long id, Long departmentId, String name, int age, String position) {
}
