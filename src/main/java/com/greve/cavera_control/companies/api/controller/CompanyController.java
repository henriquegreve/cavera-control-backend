package com.greve.cavera_control.companies.api.controller;

import com.greve.cavera_control.auth.config.TokenService;
import com.greve.cavera_control.companies.api.dto.CompanyDTO;
import com.greve.cavera_control.companies.model.Company;
import com.greve.cavera_control.companies.service.CompanyService;
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
@RequiredArgsConstructor
@RequestMapping("/companies")
@Slf4j
public class CompanyController {

    private final CompanyService service;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<CompanyDTO> createCompany(@RequestBody @Valid CompanyDTO dto, @RequestHeader("Authorization") String token) {
        log.info(" Creating new company with Name: {} ", dto.getName());
        Long userId = tokenService.getUserFromToken(token);
        Company entity = service.save(userId, convertToEntity(dto, Company.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDTO(entity, CompanyDTO.class));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<CompanyDTO>> getAll(Pageable pageable) {
        log.info(" Obtaining all companies ");
        return ResponseEntity.ok(convertToDTO(service.getAll(pageable), CompanyDTO.class));
    }

}
