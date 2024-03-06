package com.example.yttest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "chassisnumber", nullable = false, length = 17)
    private String chassisnumber;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "cartype", nullable = false)
    private String cartype;

    @Column(name = "transmission", nullable = false, length = 20)
    private String transmission;

    @Column(name = "firstregistration", nullable = false)
    private Instant firstregistration;

    @Column(name = "mileage", nullable = false)
    private Integer mileage;

    @Column(name = "enginepower", nullable = false)
    private Integer enginepower;


    @Column(name = "cylinder", nullable = false)
    private Integer cylinder;

    @Column(name = "fuel", nullable = false)
    private String fuel;

    @Column(name = "co2", nullable = false, length = 5)
    private String co2;

    @Column(name = "color", nullable = false, length = 20)
    private String color;

    @Column(name = "numberkeys", nullable = false)
    private Integer numberkeys;

    @Column(name = "cerofconf", nullable = false)
    private Boolean cerofconf = false;

    @Column(name = "inspectionform", nullable = false)
    private Boolean inspectionform = false;

    @Column(name = "carpass", nullable = false)
    private Boolean carpass = false;

    @Column(name = "registercert", nullable = false)
    private Boolean registerCert=false;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;
    private int compagny_id;
}