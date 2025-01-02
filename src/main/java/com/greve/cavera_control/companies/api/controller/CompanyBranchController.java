package com.greve.cavera_control.companies.api.controller;

import com.greve.cavera_control.auth.config.TokenService;
import com.greve.cavera_control.companies.api.dto.CompanyBranchDTO;
import com.greve.cavera_control.companies.model.CompanyBranch;
import com.greve.cavera_control.companies.service.CompanyBranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.greve.cavera_control.util.EntityConverter.convertToDTO;
import static com.greve.cavera_control.util.EntityConverter.convertToEntity;

@RestController
@RequestMapping("/companies-branches")
@RequiredArgsConstructor
@Slf4j
public class CompanyBranchController {

    private final CompanyBranchService service;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<CompanyBranchDTO> createCompanyBranch(@RequestBody @Valid CompanyBranchDTO dto, @RequestHeader("Authorization") String token) {
        log.info(" Creating new Company Branch with Name: {} ", dto.getName());
        Long userId = tokenService.getUserFromToken(token);
        CompanyBranch entity = service.save(userId, convertToEntity(dto, CompanyBranch.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDTO(entity, CompanyBranchDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyBranchDTO> getById(@PathVariable final Long id) {
        log.info(" Obtaining Company Branch with ID: {} ", id);
        return ResponseEntity.ok(convertToDTO(service.getById(id), CompanyBranchDTO.class));
    }

    @GetMapping("/company/{idCompany}")
    public ResponseEntity<Page<CompanyBranchDTO>> getAllByCompanyId(@PathVariable final Long idCompany, Pageable pageable) {
        log.info(" Obtaining all with Company ID: {} ", idCompany);
        return ResponseEntity.ok(convertToDTO(service.getAllByIdCompany(idCompany, pageable), CompanyBranchDTO.class));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<CompanyBranchDTO>> getAll(Pageable pageable) {
        log.info(" Obtaining all Company Branches ");
        return ResponseEntity.ok(convertToDTO(service.getAll(pageable), CompanyBranchDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyBranchDTO> updateCompanyBranch(@PathVariable final Long id, @RequestBody @Valid CompanyBranchDTO dto, @RequestHeader("Authorization") String token) {
        log.info(" Updating Company Branch with ID: {} ", id);
        Long userId = tokenService.getUserFromToken(token);
        CompanyBranch cb = service.update(userId, id, convertToEntity(dto, CompanyBranch.class));
        return ResponseEntity.ok(convertToDTO(cb, CompanyBranchDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyBranch(@PathVariable final Long id) {
        log.info(" Deleting Company Branch with ID: {} ", id);
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
