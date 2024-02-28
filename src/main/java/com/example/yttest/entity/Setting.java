package com.example.yttest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "settings")
public class Setting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "company_logo")
    private String companyLogo;

    @Column(name = "company_name", nullable = false, length = 50)
    private String companyName;

    @Column(name = "owner_name", nullable = false, length = 50)
    private String ownerName;

    @Column(name = "owner_lastname", nullable = false, length = 50)
    private String ownerLastname;

    @Column(name = "vat_number", nullable = false)
    private String vatNumber;

    @Column(name = "street", nullable = false, length = 50)
    private String street;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "owner_email", nullable = false, length = 50)
    private String ownerEmail;

    @Column(name = "owner_phone", nullable = false)
    private String ownerPhone;

    @Column(name = "owner_website", nullable = false, length = 50)
    private String ownerWebsite;

    @Column(name = "bank_name", nullable = false, length = 50)
    private String bankName;

    @Column(name = "bank_account_number", nullable = false)
    private String bankAccountNumber;

    @Column(name = "bic_number", nullable = false)
    private String bicNumber;

    @Column(name = "bank_name2", length = 50)
    private String bankName2;

    @Column(name = "bank_account_number2", length = 50)
    private String bankAccountNumber2;

    @Column(name = "bic_number2", length = 50)
    private String bicNumber2;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}