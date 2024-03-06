package com.example.yttest.config;


import java.io.IOException;
import java.util.List;

import com.example.yttest.dto.InvoiceDtoRes;
import com.example.yttest.dto.SettingDtoRes;
import com.example.yttest.entity.Invoice;
import com.example.yttest.service.interfaces.ICar;
import com.example.yttest.service.interfaces.IInvoice;
import com.itextpdf.text.BaseColor;


import com.lowagie.text.*;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class PDFGenerator {


    private InvoiceDtoRes invoice;
    private SettingDtoRes setting;


    public void generate(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTitle.setSize(20);
        fontTitle.setStyle(Font.BOLD);
        Paragraph title = new Paragraph("Invoice", fontTitle);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);
        document.add(new Paragraph(" "));
        document.add(new Paragraph(invoice.getClient().getCompanyname()));


    }


    //public void generate(HttpServletResponse response) throws DocumentException, IOException {
//    // Creating the Object of Document
//    Document document = new Document(PageSize.A4);
//
//    // Getting instance of PdfWriter
//    PdfWriter.getInstance(document, response.getOutputStream());
//
//    // Opening the created document to modify it
//    document.open();
//
//    // Creating font for title
//    Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//    fontTitle.setSize(20);
//    fontTitle.setStyle(Font.BOLD);
//
//    // Creating paragraph for title
//    Paragraph title = new Paragraph("Invoice", fontTitle);
//    title.setAlignment(Paragraph.ALIGN_CENTER);
//    document.add(title);
//
//    // Adding space between title and table
//    document.add(new Paragraph(" "));
//
//    // Creating a table for invoice details
//    PdfPTable table = new PdfPTable(2);
//    table.setWidthPercentage(100);
//
//    // Creating font for table headers
//    Font fontHeader = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//    fontHeader.setColor(BaseColor.WHITE);
//    fontHeader.setStyle(Font.BOLD);
//
//    // Creating cell styles for header cells
//    PdfPCell headerCell = new PdfPCell();
//    headerCell.setBackgroundColor(BaseColor.DARK_GRAY);
//    headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//    headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//    headerCell.setPadding(5);
//
//    // Adding headers to the table
//    headerCell.setPhrase(new Phrase("Description", fontHeader));
//    table.addCell(headerCell);
//    headerCell.setPhrase(new Phrase("Amount", fontHeader));
//    table.addCell(headerCell);
//
//    // Adding invoice details to the table
//    table.addCell("Car Rental");
//    table.addCell("$" + invoice.getAmount());
//
//    // Adding the table to the document
//    document.add(table);
//
//    // Closing the document
//    document.close();
//}

}
