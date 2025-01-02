package com.greve.cavera_control.companies.service;

import com.greve.cavera_control.companies.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyService {

    Company save(final Long userId, Company entity);

    Page<Company> getAll(Pageable pageable);

}
