package com.example.yttest.service.impl;


import com.example.yttest.dto.InvoiceDtoReq;
import com.example.yttest.dto.InvoiceDtoRes;

import com.example.yttest.entity.Invoice;
import com.example.yttest.repository.InvoiceRepository;
import com.example.yttest.service.interfaces.IInvoice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
@Service
public class InvoiceService implements IInvoice {
    private final InvoiceRepository invoiceRepository;
    @Autowired
    private ModelMapper modelMapper;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }


    @Override
    public List<InvoiceDtoRes> findAll() {
        List<Invoice> invoice = invoiceRepository.findAll();
        return invoice.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public InvoiceDtoRes findById(Integer id) {
        Invoice invoice = invoiceRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
        return convertToDto(invoice);
    }

    @Override
    public InvoiceDtoRes createUser(InvoiceDtoReq invoiceCreateDto) {
        Invoice invoice = convertToEntity(invoiceCreateDto);
        Invoice savedClient = invoiceRepository.save(invoice);
        return convertToDto(savedClient);
    }

    @Override
    public long count() {
        return invoiceRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        invoiceRepository.deleteById(Long.valueOf(id));
    }

    private InvoiceDtoRes convertToDto(Invoice invoice) {
        return modelMapper.map(invoice, InvoiceDtoRes.class);
    }

    private Invoice convertToEntity(InvoiceDtoReq invoiceDtoReq) {
        return modelMapper.map(invoiceDtoReq, Invoice.class);
    }
}
