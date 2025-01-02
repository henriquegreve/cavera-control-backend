package com.greve.cavera_control.companies.repository;

import com.greve.cavera_control.companies.model.CompanyBranch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyBranchRepository extends JpaRepository<CompanyBranch, Long> {

    boolean existsByName(String name);

    boolean existsByBusinessName(String businessName);

    boolean existsByCompanyRegister(String companyRegister);

    Page<CompanyBranch> findByIdCompany(Long idCompany, Pageable pageable);

}
