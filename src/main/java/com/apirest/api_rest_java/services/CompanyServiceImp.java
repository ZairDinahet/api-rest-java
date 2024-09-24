package com.apirest.api_rest_java.services;

import com.apirest.api_rest_java.exceptions.CustomException;
import com.apirest.api_rest_java.mappers.CompanyMapper;
import com.apirest.api_rest_java.models.dtos.CompanyDTO;
import com.apirest.api_rest_java.models.entities.Company;
import com.apirest.api_rest_java.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CompanyServiceImp implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public List<CompanyDTO> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream().map(companyMapper::convertToDTO) //.map(company -> companyMapper.convertToDTO(company))
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDTO getCompanyById(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new CustomException("Company not found with id: " + id, HttpStatus.NOT_FOUND));
        return companyMapper.convertToDTO(company);
    }

    @Override
    public CompanyDTO saveCompany(CompanyDTO companyDTO) {
        Company company = companyMapper.convertToEntity(companyDTO);
        Company savedCompany = companyRepository.save(company);
        return companyMapper.convertToDTO(savedCompany);
    }

    @Override
    public CompanyDTO updateCompany(Long id, CompanyDTO companyDTO) {
        Company existingCompany = companyRepository.findById(id)
                .orElseThrow(() -> new CustomException("Company not found with id: " + id, HttpStatus.NOT_FOUND));

        existingCompany.setName(companyDTO.getName());
        existingCompany.setAddress(companyDTO.getAddress());

        Company updatedCompany = companyRepository.save(existingCompany);

        return companyMapper.convertToDTO(updatedCompany);
    }

    @Override
    public void deleteCompanyById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new CustomException("Company not found with id: " + id, HttpStatus.NOT_FOUND));
        companyRepository.delete(company);
    }
}
