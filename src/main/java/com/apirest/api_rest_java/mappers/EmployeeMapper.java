package com.apirest.api_rest_java.mappers;

import com.apirest.api_rest_java.models.dtos.EmployeeDTO;
import com.apirest.api_rest_java.models.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
     @Mapping(source = "company.id", target = "companyId")  // Asegura que companyId se extrae del objeto company
     EmployeeDTO convertToDTO(Employee employee);

     // Método para mapear de DTO a Entity
     @Mapping(source = "companyId", target = "company.id")  // Mapea el companyId a la entidad company
     Employee convertToEntity(EmployeeDTO employeeDTO);
}
