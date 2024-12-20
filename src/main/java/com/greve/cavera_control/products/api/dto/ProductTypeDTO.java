package com.greve.cavera_control.products.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductTypeDTO {

    private Long id;
    private Integer ordenation;
    private String name;
    private Long createUserId;
    private Long modifyUserId;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

}
