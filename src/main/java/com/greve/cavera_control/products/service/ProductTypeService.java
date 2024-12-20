package com.greve.cavera_control.products.service;

import com.greve.cavera_control.products.model.ProductType;

import java.util.List;

public interface ProductTypeService {

    ProductType save(final Long userId, ProductType pt);

    List<ProductType> saveAll(final Long userId, List<ProductType> ptList);

    ProductType getById(final Long id);

    List<ProductType> getAll();

    ProductType update(final Long id, final Long userId, ProductType pt);

    void delete(final Long id);

}
