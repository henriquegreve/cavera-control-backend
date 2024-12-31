package com.greve.cavera_control.companies.repository;

import com.greve.cavera_control.companies.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    boolean existsByName(String name);

    boolean existsByBusinessName(String businessName);

    boolean existsByCompanyRegister(String companyRegister);

}
