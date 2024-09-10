package com.apirest.api_rest_java.models.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String position;
    private String email;
    private String address;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

}
