package com.example.yttest.dto;

import com.example.yttest.entity.Car;
import com.example.yttest.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
@Data
@RequiredArgsConstructor
/**
 * DTO for {@link com.example.yttest.entity.Invoice}
 */
//@Value
public class InvoiceDtoRes implements Serializable {
    Long id;
    ClientDtoRes client;
    CarDtoRes car;
    LocalDate date;
    LocalDate duedate;
    BigDecimal advance;
    BigDecimal amount;
    String paymentmethod;
    Boolean paidstatus;
    String memo;
    Instant createdAt;
    Instant updatedAt;
}