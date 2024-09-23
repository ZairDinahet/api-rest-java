package com.apirest.api_rest_java.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    private Long id;         // Identificador único del empleado
    private String name;     // Nombre del empleado
    private String lastName; // Apellido del empleado
    private String position; // Cargo del empleado
    private String address;  // Dirección del empleado
    private String email;    // Correo electrónico del empleado
    private String phone;    // Teléfono del empleado
    private Long companyId;  // Identificador único de la empresa
}
