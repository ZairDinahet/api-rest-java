package com.apirest.api_rest_java.repositories;

import com.apirest.api_rest_java.models.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
