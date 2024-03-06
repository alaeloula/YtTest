package com.example.yttest.service.interfaces;


import com.example.yttest.dto.InvoiceDtoReq;
import com.example.yttest.dto.InvoiceDtoRes;

import java.util.List;

public interface IInvoice {
    List<InvoiceDtoRes> findAll();

    InvoiceDtoRes findById(Integer id);
    InvoiceDtoRes createUser(InvoiceDtoReq invoiceDtoRes);

    long count();

    void deleteById(Integer id);
}
