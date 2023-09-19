package com.exam.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.exam.to.ForPdfTO;

//import com.lowagie.text.pdf.codec.Base64.InputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@Service
public class PDFgeneration {

	Logger log = LogManager.getLogger(PDFgeneration.class);

	private static final String BGIMAGE = "/certi.png";
	private final String invoice_template_path = "/Blank_A4_Landscape.jrxml";

    @SuppressWarnings("null")
	public byte[] generateInvoiceFor(String name, String format,ForPdfTO forpdf) throws IOException {
    	File f = null;
    	byte[] blob=null;
//        File pdfFile = File.createTempFile("my-invoice", ".pdf");
//    	File pdfFile = ResourceUtils.getFile("classpath: Blank_A4_Landscape.jrxml");

//        try(FileOutputStream pos = new FileOutputStream(pdfFile))
    	try
        {
			// Load the invoice .jrxml template.
            final JasperReport report = loadTemplate();

              // Create parameters map.
            final Map<String, Object> parameters = parameters(name,forpdf);

            // Create an empty dataSource.
            final JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Collections.singletonList("Invoice"));

            // Render the PDF file
//            JasperReportsUtils.renderAsPdf(report, parameters, dataSource, pos);
            JasperPrint print= JasperFillManager.fillReport(report, parameters,dataSource);
//            String format = "html";
//            JRPdfExporter.
//            if(format=="PDF")
//            JasperExportManager.exportReportToPdfFile(print, "D:\\springBootProject\\ExamServer\\certi.pdf");
////            else
            	blob = JasperExportManager.exportReportToPdf(print);
            	return blob;
//            	 JasperExportManager.exportReportToPdf(print);
//             f=ResourceUtils.getFile("D:\\springBootProject\\ExamServer\\certi.html");
            
            

        }
        catch (final Exception e)
        {
            log.error(String.format("An error occured during PDF creation: %s", e));
        }
		return blob;
    }
        private Map<String, Object> parameters(String name,ForPdfTO forpdf) throws IOException, JRException {
            final Map<String, Object> parameters = new HashMap<>();
//            final InputStream reportInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(BGIMAGE);;
////            BufferedImage bImage = ImageIO.read(new File(BGIMAGE));
////            ByteArrayOutputStream bos = new ByteArrayOutputStream();
////            ImageIO.write(bImage, "png", bos );
////            byte [] data = bos.toByteArray();
//            parameters.put("BGIMAGE", JRLoader.loadBytes(reportInputStream));
            parameters.put("FullName","  "+name);
//            parameters.put("REPORT_LOCALE", locale);
            parameters.put("Quiz", forpdf.getName());
            parameters.put("marks", forpdf.getPercent());
            parameters.put("Date",LocalDate.now().toString());

            return parameters;
        }
        private JasperReport loadTemplate() throws JRException {

            log.info(String.format("Invoice template path : %s", invoice_template_path));

            final InputStream reportInputStream = getClass().getResourceAsStream(invoice_template_path);
            final JasperDesign jasperDesign = JRXmlLoader.load(reportInputStream);

            return JasperCompileManager.compileReport(jasperDesign);
        }
    

    // ...
}
