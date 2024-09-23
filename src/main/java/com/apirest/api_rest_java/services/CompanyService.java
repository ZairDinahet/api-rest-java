package com.apirest.api_rest_java.services;

import com.apirest.api_rest_java.models.dtos.CompanyDTO;
import com.apirest.api_rest_java.models.entities.Company;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyService {

    List<CompanyDTO> getAllCompanies();        // Devuelve la lista de CompanyDTOs.
    CompanyDTO getCompanyById(Long id);     // Devuelve un CompanyDTO por su ID.
    CompanyDTO saveCompany(CompanyDTO companyDTO);  // Guarda y devuelve el CompanyDTO guardado.
    CompanyDTO updateCompany(Long id, CompanyDTO companyDTO);  // Actualiza y devuelve el CompanyDTO actualizado.
    void deleteCompanyById(Long id);

}