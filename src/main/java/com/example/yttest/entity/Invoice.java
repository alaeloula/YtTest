package com.example.yttest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "duedate")
    private LocalDate duedate;

    @Column(name = "advance", nullable = false, precision = 10, scale = 2)
    private BigDecimal advance;

    @Column(name = "amount", nullable = false, precision = 8, scale = 2)
    private BigDecimal amount;

    @Column(name = "paymentmethod", nullable = false)
    private String paymentmethod;

    @Column(name = "paidstatus", nullable = false)
    private Boolean paidstatus = false;

    @Column(name = "memo")
    private String memo;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "compagny_id", nullable = false)
    private Setting compagny;

}