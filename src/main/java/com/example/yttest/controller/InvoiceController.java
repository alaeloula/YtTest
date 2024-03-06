package com.example.yttest.controller;

import com.example.yttest.config.PDFGenerator;
import com.example.yttest.dto.InvoiceDtoReq;
import com.example.yttest.dto.InvoiceDtoRes;
import com.example.yttest.service.interfaces.IInvoice;
import com.itextpdf.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private IInvoice invoiceService;

    @GetMapping
    public List<InvoiceDtoRes> getAllInvoices() {
        return invoiceService.findAll();
    }

    @GetMapping("/{id}")
    public InvoiceDtoRes getInvoiceById(@PathVariable Integer id) {
        return invoiceService.findById(id);
    }

    @PostMapping
    public InvoiceDtoRes createInvoice(@RequestBody InvoiceDtoReq invoiceDtoReq) {
        return invoiceService.createUser(invoiceDtoReq);
    }
//    @GetMapping("/pdf")
//    public void generatePdf(HttpServletResponse response,int id) throws DocumentException, IOException {
//
//        response.setContentType("application/pdf");
//        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
//        String currentDateTime = dateFormat.format(new Date());
//        String headerkey = "Content-Disposition";
//        String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
//        response.setHeader(headerkey, headervalue);
//
//        InvoiceDtoRes invoice = invoiceService.findById(id);
//
//        PDFGenerator generator = new PDFGenerator();
//        generator.setInvoice(invoice);
//        generator.generate(response);
//
//    }

    @GetMapping("/pdf")
    public void generatePdf(HttpServletResponse response, @RequestParam("id") int id) throws DocumentException, IOException {

        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
        String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerkey, headervalue);

        InvoiceDtoRes invoice = invoiceService.findById(id);

        PDFGenerator generator = new PDFGenerator();
        generator.setInvoice(invoice);
        generator.generate(response);

    }
    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable Integer id) {
        invoiceService.deleteById(id);
    }
}

