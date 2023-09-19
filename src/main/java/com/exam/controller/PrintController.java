package com.exam.controller;

import java.io.IOException;
import java.security.Principal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.service.impl.PDFgeneration;
import com.exam.to.ForPdfTO;

@RestController
@RequestMapping("/print")
@CrossOrigin("*")
public class PrintController {
	Logger log = LogManager.getLogger(PDFgeneration.class);
	@Autowired
	PDFgeneration pdfGen;
	@PostMapping("/pdf")
	ResponseEntity<?> getHtml(Principal principal,@RequestBody ForPdfTO forpdf) throws IOException
	{
		
		log.info(principal.getName());
		byte[] pdfData=pdfGen.generateInvoiceFor(principal.getName(),"PDF",forpdf);
	System.out.println("pdf blob"+pdfData);
		return ResponseEntity.ok(pdfData);
	}

}
