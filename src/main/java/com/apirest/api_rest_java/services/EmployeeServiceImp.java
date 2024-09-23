package com.apirest.api_rest_java.services;

import com.apirest.api_rest_java.exceptions.CustomException;
import com.apirest.api_rest_java.mappers.EmployeeMapper;
import com.apirest.api_rest_java.models.dtos.EmployeeDTO;
import com.apirest.api_rest_java.models.entities.Company;
import com.apirest.api_rest_java.models.entities.Employee;
import com.apirest.api_rest_java.repositories.CompanyRepository;
import com.apirest.api_rest_java.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employeeMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new CustomException("Employee not found with id: " + id, HttpStatus.NOT_FOUND));
        return employeeMapper.convertToDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getEmployeesByCompanyId(Long id) {
        List<Employee> employees = employeeRepository.findByCompanyId(id);
        return employees.stream()
                .map(employeeMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.convertToEntity(employeeDTO);

        Company company = companyRepository.findById(employeeDTO.getCompanyId())
                .orElseThrow(() -> new CustomException("Company not found with id: " + employeeDTO.getCompanyId(), HttpStatus.NOT_FOUND));

        employee.setCompany(company);
        Employee savedEmployee = employeeRepository.save(employee);

        return employeeMapper.convertToDTO(savedEmployee);

    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new CustomException("Employee not found with id: " + id, HttpStatus.NOT_FOUND));

        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setLastName(employeeDTO.getLastName());
        existingEmployee.setAddress(employeeDTO.getAddress());
        existingEmployee.setEmail(employeeDTO.getEmail());
        existingEmployee.setPhone(employeeDTO.getPhone());
        existingEmployee.setPosition(employeeDTO.getPosition());

        Employee updatedEmployee = employeeRepository.save(existingEmployee);

        return employeeMapper.convertToDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new CustomException("Employee not found with id: " + id, HttpStatus.NOT_FOUND));
        employeeRepository.delete(employee);
    }
}
