package com.greve.cavera_control.products.api.controller;

import com.greve.cavera_control.auth.config.TokenService;
import com.greve.cavera_control.auth.service.UserService;
import com.greve.cavera_control.products.api.dto.ProductTypeDTO;
import com.greve.cavera_control.products.model.ProductType;
import com.greve.cavera_control.products.service.ProductTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.greve.cavera_control.util.EntityConverter.convertToDTO;
import static com.greve.cavera_control.util.EntityConverter.convertToEntity;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products-types")
@Slf4j
public class ProductTypeController {

    private final ProductTypeService service;
    private final TokenService tokenService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ProductTypeDTO> createPt(@RequestBody @Valid ProductTypeDTO dto, @RequestHeader("Authorization") String token) {
        log.info(" Creating new Product Type with name: {} ", dto.getName());
        Long userId = tokenService.getUserFromToken(token);
        ProductType productType = service.save(userId, convertToEntity(dto, ProductType.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDTO(productType, ProductTypeDTO.class));
    }

    @PostMapping("/synch")
    public ResponseEntity<List<ProductTypeDTO>> synchPt(@RequestBody @Valid List<ProductTypeDTO> dtoList, @RequestHeader("Authorization") String token) {
        log.info(" Synchronizing all Product Types ");
        Long userId = tokenService.getUserFromToken(token);
        List<ProductType> ptList = service.saveAll(userId, convertToEntity(dtoList, ProductType.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDTO(ptList, ProductTypeDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductTypeDTO> getById(@PathVariable final Long id) {
        log.info(" Obtaining Product Type with ID: {} ", id);
        ProductType pt = service.getById(id);
        return ResponseEntity.ok().body(convertToDTO(pt, ProductTypeDTO.class));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductTypeDTO>> getAll() {
        log.info(" Obtaining all Product Types ");
        List<ProductType> allPt = service.getAll();
        return ResponseEntity.ok().body(convertToDTO(allPt, ProductTypeDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductTypeDTO> updatePt(@PathVariable final Long id, @RequestBody @Valid ProductTypeDTO dto, @RequestHeader("Authorization") String token) {
        log.info(" Updating Product Type with ID: {} ", dto.getId());
        Long userId = tokenService.getUserFromToken(token);
        ProductType pt = service.update(id, userId, convertToEntity(dto, ProductType.class));
        return ResponseEntity.ok().body(convertToDTO(pt, ProductTypeDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePt(@PathVariable final Long id) {
        log.info(" Deleting Product Type with ID: {} ", id);
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
