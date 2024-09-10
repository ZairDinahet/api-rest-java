package com.apirest.api_rest_java.repositories;

import com.apirest.api_rest_java.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

