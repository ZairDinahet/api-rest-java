package com.apirest.api_rest_java.models.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompanyDTO {

    private Long id;
    private String name;
    private String address;

    private List<EmployeeDTO> employees;

}
