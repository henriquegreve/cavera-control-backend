package com.greve.cavera_control.products.api.dto;

import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private Long idCompany;
    @NotNull
    private Long idBranch;
    private Integer ordenation;
    @NotNull
    private String name;
    private String description;
    private Long createUserId;
    private Long modifyUserId;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

}
