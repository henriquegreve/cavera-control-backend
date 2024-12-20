package com.greve.cavera_control.products.service.impl;

import com.greve.cavera_control.auth.service.UserService;
import com.greve.cavera_control.exception.BusinessException;
import com.greve.cavera_control.products.model.ProductType;
import com.greve.cavera_control.products.repository.ProductTypeRepository;
import com.greve.cavera_control.products.service.ProductTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductTypeServiceImpl implements ProductTypeService {
    
    private final ProductTypeRepository repository;
    private final UserService userService;

    @Override
    public ProductType save(final Long userId, ProductType pt) {
        String name = pt.getName();
        
        if (existsByName(name)) {
            throw new BusinessException("Categoria de produto com o nome: " + name + ", já existe");
        }

        pt.setCreateUserId(userId);
        pt.setModifyUserId(userId);
        pt.setCreateDate(LocalDateTime.now());
        pt.setModifyDate(LocalDateTime.now());

        return repository.save(pt);
    }

    @Override
    public List<ProductType> saveAll(final Long userId, List<ProductType> ptList) {
        ptList.forEach(pt -> {
            if (existsByName(pt.getName())) {
                ptList.remove(pt);
            } else {
                pt.setCreateUserId(userId);
                pt.setModifyUserId(userId);
                pt.setCreateDate(LocalDateTime.now());
                pt.setModifyDate(LocalDateTime.now());
            }
        });

        return repository.saveAll(ptList);
    }

    @Override
    public ProductType getById(final Long id) {
        Optional<ProductType> pt = repository.findById(id);
        return pt.orElseThrow( () ->  new BusinessException("Categoria não encontrada para o ID informado."));
    }

    @Override
    public List<ProductType> getAll() {
        return repository.findAll();
    }

    @Override
    public ProductType update(final Long id, final Long userId, ProductType productType) {
        ProductType pt = repository.findById(id).orElseThrow( () -> new BusinessException(" Product Type with ID: " + id + " not found. "));

        pt.setName(productType.getName());
        pt.setOrdenation(productType.getOrdenation());
        pt.setModifyUserId(userId);
        pt.setModifyDate(LocalDateTime.now());

        return repository.save(pt);
    }

    @Override
    public void delete(final Long id) {
        ProductType pt = repository.findById(id).orElseThrow( () -> new BusinessException(" Product Type with ID: " + id + " not found. "));
        repository.delete(pt);
    }

    private boolean existsByName(String name) {
        return repository.findByName(name) != null;
    }
}
