package com.apirest.api_rest_java.models.dtos;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    private Long id;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Last name is required")
    private String lastName;

    @NotEmpty(message = "Position is required")
    private String position;

    @NotEmpty(message = "Address is required")
    private String address;

    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Phone is required")
    private String phone;

    private Long companyId;
}
