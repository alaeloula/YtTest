package com.example.yttest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "iscompany", nullable = false)
    private Boolean iscompany = false;

    @Column(name = "surname")
    private String surname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "companyname")
    private String companyname;

    @Column(name = "btwnumber")
    private String btwnumber;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "postalcode", nullable = false, length = 10)
    private String postalcode;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false, length = 20)
    private String country;

    @Column(name = "email", length = 30)
    private String email;

    @Column(name = "phonenumber", length = 20)
    private String phonenumber;

    @Column(name = "mobilenumber", length = 20)
    private String mobilenumber;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}