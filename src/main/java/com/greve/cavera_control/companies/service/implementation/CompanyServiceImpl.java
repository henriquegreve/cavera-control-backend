package com.greve.cavera_control.companies.service.implementation;

import com.greve.cavera_control.companies.model.Company;
import com.greve.cavera_control.companies.repository.CompanyRepository;
import com.greve.cavera_control.companies.service.CompanyService;
import com.greve.cavera_control.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;

    @Override
    public Company save(final Long userId, Company entity) {
        if (repository.existsByName(entity.getName())) throw new BusinessException("Nome já está sendo utilizado.");
        if (repository.existsByBusinessName(entity.getBusinessName())) throw new BusinessException("Nome Fantasia já está sendo utilizado.");
        if (repository.existsByCompanyRegister(entity.getCompanyRegister())) throw new BusinessException("CNPJ já está sendo utilizado.");

        entity.setIdCreateUser(userId);
        entity.setIdModifyUser(userId);
        entity.setCreateDate(LocalDateTime.now());
        entity.setModifyDate(LocalDateTime.now());

        return repository.save(entity);
    }

    @Override
    public Page<Company> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
