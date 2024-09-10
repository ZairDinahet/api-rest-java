package com.apirest.api_rest_java.controllers;

import com.apirest.api_rest_java.models.entities.Company;
import com.apirest.api_rest_java.models.entities.Employee;
import com.apirest.api_rest_java.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company with Id " + id + " not found"));
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getCompanyEmployees(@PathVariable Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company with Id " + id + " not found")).getEmployees();
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Long id, @RequestBody Company company) {
        Company companyFound = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company with Id " + id + " not found"));
        companyFound.setAddress(company.getAddress());
        companyFound.setName(company.getName());

        return companyRepository.save(companyFound);
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable Long id) {
        Company companyFound = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company with Id " + id + " not found"));

        companyRepository.delete(companyFound);
        return "Company with Id " + id + " deleted";
    }
}
