package com.greve.cavera_control.companies.service.implementation;

import com.greve.cavera_control.companies.model.CompanyBranch;
import com.greve.cavera_control.companies.repository.CompanyBranchRepository;
import com.greve.cavera_control.companies.service.CompanyBranchService;
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
public class CompanyBranchServiceImpl implements CompanyBranchService {

    private static final String COMPANY_BRANCH_NOT_FOUND_WITH_ID = "Company Branch not found with ID: ";

    private final CompanyBranchRepository repository;

    @Override
    public CompanyBranch save(final Long userId, CompanyBranch cb) {
        if (repository.existsByName(cb.getName())) throw new BusinessException("Nome já está sendo utilizado.");
        if (repository.existsByBusinessName(cb.getBusinessName())) throw new BusinessException("Nome Fantasia já está sendo utilizado.");
        if (repository.existsByCompanyRegister(cb.getCompanyRegister())) throw new BusinessException("CNPJ já está sendo utilizado.");

        cb.setIdCreateUser(userId);
        cb.setIdModifyUser(userId);
        cb.setCreateDate(LocalDateTime.now());
        cb.setModifyDate(LocalDateTime.now());

        return repository.save(cb);
    }

    @Override
    public CompanyBranch getById(final Long id) {
        return repository.findById(id).orElseThrow(() -> new BusinessException(COMPANY_BRANCH_NOT_FOUND_WITH_ID + id));
    }

    @Override
    public Page<CompanyBranch> getAllByIdCompany(final Long idCompany, Pageable pageable) {
        return repository.findByIdCompany(idCompany, pageable);
    }

    @Override
    public Page<CompanyBranch> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public CompanyBranch update(final Long userId, final Long id, CompanyBranch data) {
        CompanyBranch cb = repository.findById(id).orElseThrow(() -> new BusinessException(COMPANY_BRANCH_NOT_FOUND_WITH_ID + id));

        if (repository.existsByName(data.getName())) throw new BusinessException("Nome já está sendo utilizado.");
        if (repository.existsByBusinessName(data.getBusinessName())) throw new BusinessException("Nome Fantasia já está sendo utilizado.");
        if (repository.existsByCompanyRegister(data.getCompanyRegister())) throw new BusinessException("CNPJ já está sendo utilizado.");

        cb.setActive(data.getActive());
        cb.setName(data.getName());
        cb.setBusinessName(data.getBusinessName());
        cb.setCompanyRegister(data.getCompanyRegister());
        cb.setIdCompany(data.getIdCompany());
        cb.setAddressStreet(data.getAddressStreet());
        cb.setAddressNumber(data.getAddressNumber());
        cb.setAddressNeighborhood(data.getAddressNeighborhood());
        cb.setAddressCity(data.getAddressCity());
        cb.setAddressCountry(data.getAddressCountry());
        cb.setAddressComplement(data.getAddressComplement());
        cb.setAddressState(data.getAddressState());
        cb.setAddressPostalCode(data.getAddressPostalCode());
        cb.setCityRegistration(data.getCityRegistration());
        cb.setStatRegistration(data.getStatRegistration());
        cb.setEmail(data.getEmail());
        cb.setContact(data.getContact());
        cb.setPhone01Prefix(data.getPhone01Prefix());
        cb.setPhone01Number(data.getPhone01Number());
        cb.setPhone02Prefix(data.getPhone02Prefix());
        cb.setPhone02Number(data.getPhone02Number());
        cb.setImage(data.getImage());

        cb.setIdModifyUser(userId);
        cb.setModifyDate(LocalDateTime.now());

        return repository.save(cb);
    }

    @Override
    public void delete(final Long id) {
        CompanyBranch cb = repository.findById(id).orElseThrow(() -> new BusinessException(COMPANY_BRANCH_NOT_FOUND_WITH_ID + id));
        repository.delete(cb);
        log.info(" Company Branch with ID: {} deleted successfully ", id);
    }
}
