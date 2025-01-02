package com.greve.cavera_control.companies.api.dto;

import jakarta.validation.constraints.NotEmpty;
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
public class CompanyBranchDTO {

    private Long id;
    @NotNull
    private Long idCompany;
    @NotEmpty
    private String name;
    @NotEmpty
    private String businessName;
    @NotEmpty
    private Boolean active;
    @NotEmpty
    private String companyRegister;
    private String statRegistration;
    private String cityRegistration;
    @NotEmpty
    private String email;
    private String contact;
    private String phone01Prefix;
    private String phone01Number;
    private String phone02Prefix;
    private String phone02Number;
    private String addressStreet;
    private String addressNumber;
    private String addressComplement;
    private String addressNeighborhood;
    private String addressCity;
    private String addressState;
    private String addressCountry;
    private String addressPostalCode;
    private Long idImage;
    private Long idCreateUser;
    private LocalDateTime createDate;
    private Long idModifyUser;
    private LocalDateTime modifyDate;

}
