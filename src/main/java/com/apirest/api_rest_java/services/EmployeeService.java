package com.apirest.api_rest_java.services;

import com.apirest.api_rest_java.models.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long id);
    List<EmployeeDTO> getEmployeesByCompanyId(Long id);
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);
    void deleteEmployeeById(Long id);
}
