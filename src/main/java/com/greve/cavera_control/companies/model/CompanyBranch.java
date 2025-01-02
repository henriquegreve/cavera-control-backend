package com.greve.cavera_control.companies.model;

import com.greve.cavera_control.images.model.Image;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "gcompanybranches", schema = "public")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyBranch {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbranch")
    private Long id;

    @Column(name = "idcompany")
    private Long idCompany;

    @Column(name = "name", nullable = false, length = 240)
    private String name;

    @Column(name = "businessname", nullable = false, length = 240)
    private String businessName;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @Column(name = "companyregister", nullable = false, length = 50)
    private String companyRegister;

    @Column(name = "statregistration", length = 50)
    private String statRegistration;

    @Column(name = "cityregistration", length = 50)
    private String cityRegistration;

    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Column(name = "contact", length = 150)
    private String contact;

    @Column(name = "phone01prefix", length = 5)
    private String phone01Prefix;

    @Column(name = "phone01number", length = 20)
    private String phone01Number;

    @Column(name = "phone02prefix", length = 5)
    private String phone02Prefix;

    @Column(name = "phone02number", length = 20)
    private String phone02Number;

    @Column(name = "adressstreet", length = 200)
    private String adressStreet;

    @Column(name = "adressnumber", length = 25)
    private String adressNumber;

    @Column(name = "adresscomplement", length = 50)
    private String adressComplement;

    @Column(name = "adressneighborhood", length = 150)
    private String adressNeighborhood;

    @Column(name = "adresscity", length = 150)
    private String adressCity;

    @Column(name = "adressstate", length = 150)
    private String adressState;

    @Column(name = "adresscountry", length = 150)
    private String adressCountry;

    @Column(name = "adresspostalcode", length = 25)
    private String adressPostalCode;

    @ManyToOne
    @JoinColumn(name = "idimage", referencedColumnName = "idimage", foreignKey = @ForeignKey(name = "gcompanies_idimage_fk"))
    private Image image;

    @Column(name = "createiduser", nullable = false)
    private Long idCreateUser;

    @Column(name = "createdate", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "modifyiduser", nullable = false)
    private Long idModifyUser;

    @Column(name = "modifydate", nullable = false)
    private LocalDateTime modifyDate;

}
