package com.apirest.api_rest_java.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompanyDTO {

    private Long id;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Address is required")
    private String address;

    private List<EmployeeDTO> employees;

}
