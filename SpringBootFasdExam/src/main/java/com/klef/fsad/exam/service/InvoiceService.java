package com.klef.fsad.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsad.exam.model.Invoice;
import com.klef.fsad.exam.repository.InvoiceRepository;

@Service
public class InvoiceService 
{
    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice addInvoice(Invoice invoice)
    {
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getAllInvoices()
    {
        return invoiceRepository.findAll();
    }
}