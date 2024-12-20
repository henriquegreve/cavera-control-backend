package com.greve.cavera_control.products.repository;

import com.greve.cavera_control.products.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

    ProductType findByName(String name);

}
