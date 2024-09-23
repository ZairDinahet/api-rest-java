package com.apirest.api_rest_java.mappers;

import com.apirest.api_rest_java.models.dtos.CompanyDTO;
import com.apirest.api_rest_java.models.entities.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyDTO convertToDTO(Company company);
    Company convertToEntity(CompanyDTO companyDTO);
}
