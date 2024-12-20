package com.greve.cavera_control.products.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "vproducttypes", schema = "public")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducttype")
    private Long id;

    @Column(name = "ordenation")
    private Integer ordenation;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "createiduser")
    private Long createUserId;

    @Column(name = "modifyiduser")
    private Long modifyUserId;

    @Column(name = "createdate", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "modifydate", nullable = false)
    private LocalDateTime modifyDate;

}
