package com.klef.fsad.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.fsad.exam.model.Invoice;
import com.klef.fsad.exam.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController 
{
    @Autowired
    private InvoiceService invoiceService;

    // POST Operation
    @PostMapping("/add")
    public Invoice addInvoice(@RequestBody Invoice invoice)
    {
        return invoiceService.addInvoice(invoice);
    }

    // GET Operation
    @GetMapping("/all")
    public List<Invoice> getInvoices()
    {
        return invoiceService.getAllInvoices();
    }
}