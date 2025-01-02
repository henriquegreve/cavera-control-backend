package com.greve.cavera_control.companies.service;

import com.greve.cavera_control.companies.model.CompanyBranch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyBranchService {

    CompanyBranch save(final Long userId, CompanyBranch cb);

    CompanyBranch getById(final Long id);

    Page<CompanyBranch> getAllByIdCompany(final Long idCompany, Pageable pageable);

    Page<CompanyBranch> getAll(Pageable pageable);

    CompanyBranch update(final Long userId, final Long id, final CompanyBranch data);

    void delete(final Long id);

}
