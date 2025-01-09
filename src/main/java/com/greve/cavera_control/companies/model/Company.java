package com.greve.cavera_control.companies.model;

import com.greve.cavera_control.images.model.Image;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "gcompanies", schema = "public")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcompany")
    private Long id;

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

    @Column(name = "addressstreet", length = 200)
    private String addressStreet;

    @Column(name = "addressnumber", length = 25)
    private String addressNumber;

    @Column(name = "addresscomplement", length = 50)
    private String addressComplement;

    @Column(name = "addressneighborhood", length = 150)
    private String addressNeighborhood;

    @Column(name = "addresscity", length = 150)
    private String addressCity;

    @Column(name = "addressstate", length = 150)
    private String addressState;

    @Column(name = "addresscountry", length = 150)
    private String addressCountry;

    @Column(name = "addresspostalcode", length = 25)
    private String addressPostalCode;

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
