package com.example.yttest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Locale;

import static java.time.LocalDate.now;

@Data
@RequiredArgsConstructor
/**
 * DTO for {@link com.example.yttest.entity.Invoice}
 */
//@Value
public class InvoiceDtoReq implements Serializable {
    Long id;
    Integer clientId;
    Integer carId;
    LocalDate date=LocalDate.now();
    LocalDate duedate= LocalDate.now();
    BigDecimal advance;
    BigDecimal amount;
    String paymentmethod;
    Boolean paidstatus;
    String memo;
    Instant createdAt;
    Instant updatedAt;
    int compagny_id=1;
}