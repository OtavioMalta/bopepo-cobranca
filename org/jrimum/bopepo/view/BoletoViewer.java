/*      */ package org.jrimum.bopepo.view;
/*      */ 
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.File;
/*      */ import java.io.InputStream;
/*      */ import java.net.URL;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import org.apache.log4j.Logger;
/*      */ import org.jrimum.bopepo.Boleto;
/*      */ import org.jrimum.bopepo.pdf.Files;
/*      */ import org.jrimum.utilix.Collections;
/*      */ import org.jrimum.utilix.Exceptions;
/*      */ import org.jrimum.utilix.Objects;
/*      */ import org.jrimum.utilix.text.Strings;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class BoletoViewer
/*      */ {
/*   83 */   private static Logger log = Logger.getLogger(BoletoViewer.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private PdfViewer pdfViewer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer(Boleto boleto) {
/*  105 */     checkBoleto(boleto);
/*      */     
/*  107 */     this.pdfViewer = new PdfViewer(boleto);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer(Boleto boleto, String templatePath) {
/*  125 */     checkBoleto(boleto);
/*  126 */     checkTemplatePath(templatePath);
/*      */     
/*  128 */     this.pdfViewer = new PdfViewer(boleto);
/*      */     
/*  130 */     setTemplate(templatePath);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer(Boleto boleto, File templateFile) {
/*  148 */     checkBoleto(boleto);
/*  149 */     checkTemplateFile(templateFile);
/*      */     
/*  151 */     this.pdfViewer = new PdfViewer(boleto);
/*      */     
/*  153 */     setTemplate(templateFile);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer(Boleto boleto, URL templateUrl) {
/*  171 */     checkBoleto(boleto);
/*  172 */     checkTemplateFile(templateUrl);
/*      */     
/*  174 */     this.pdfViewer = new PdfViewer(boleto);
/*      */     
/*  176 */     setTemplate(templateUrl);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer(Boleto boleto, InputStream templateInput) {
/*  194 */     checkBoleto(boleto);
/*  195 */     checkTemplateFile(templateInput);
/*      */     
/*  197 */     this.pdfViewer = new PdfViewer(boleto);
/*      */     
/*  199 */     setTemplate(templateInput);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer(Boleto boleto, byte[] template) {
/*  217 */     checkBoleto(boleto);
/*  218 */     checkTemplateFile(template);
/*      */     
/*  220 */     this.pdfViewer = new PdfViewer(boleto);
/*      */     
/*  222 */     setTemplate(template);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BoletoViewer() {
/*  230 */     this.pdfViewer = new PdfViewer();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BoletoViewer(PdfViewer pdfViewer) {
/*  238 */     this.pdfViewer = pdfViewer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BoletoViewer create(Boleto boleto) {
/*  255 */     checkBoleto(boleto);
/*      */     
/*  257 */     return new BoletoViewer(boleto);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] groupInOnePDF(List<Boleto> boletos) {
/*  277 */     checkBoletosList(boletos);
/*      */     
/*  279 */     return PdfViewerMultiProcessor.groupInOnePDF(boletos, new BoletoViewer());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File groupInOnePDF(List<Boleto> boletos, String destPath) {
/*  302 */     checkBoletosList(boletos);
/*  303 */     checkDestPath(destPath);
/*      */     
/*  305 */     return PdfViewerMultiProcessor.groupInOnePDF(boletos, new BoletoViewer(), new File(destPath));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File groupInOnePDF(List<Boleto> boletos, File destFile) {
/*  329 */     checkBoletosList(boletos);
/*  330 */     checkDestFile(destFile);
/*      */     
/*  332 */     return PdfViewerMultiProcessor.groupInOnePDF(boletos, new BoletoViewer(), destFile);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] groupInOnePdfWithTemplate(List<Boleto> boletos, String templatePath) {
/*  354 */     checkBoletosList(boletos);
/*  355 */     checkTemplatePath(templatePath);
/*      */     
/*  357 */     return PdfViewerMultiProcessor.groupInOnePDF(boletos, (new BoletoViewer()).setTemplate(templatePath));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] groupInOnePdfWithTemplate(List<Boleto> boletos, URL templateUrl) {
/*  378 */     checkBoletosList(boletos);
/*  379 */     checkTemplateFile(templateUrl);
/*      */     
/*  381 */     return PdfViewerMultiProcessor.groupInOnePDF(boletos, (new BoletoViewer()).setTemplate(templateUrl));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] groupInOnePdfWithTemplate(List<Boleto> boletos, File templateFile) {
/*  402 */     checkBoletosList(boletos);
/*  403 */     checkTemplateFile(templateFile);
/*      */     
/*  405 */     return PdfViewerMultiProcessor.groupInOnePDF(boletos, (new BoletoViewer()).setTemplate(templateFile));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] groupInOnePdfWithTemplate(List<Boleto> boletos, InputStream templateInput) {
/*  426 */     checkBoletosList(boletos);
/*  427 */     checkTemplateFile(templateInput);
/*      */     
/*  429 */     return PdfViewerMultiProcessor.groupInOnePDF(boletos, (new BoletoViewer()).setTemplate(templateInput));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] groupInOnePdfWithTemplate(List<Boleto> boletos, byte[] template) {
/*  450 */     checkBoletosList(boletos);
/*  451 */     checkTemplateFile(template);
/*      */     
/*  453 */     return PdfViewerMultiProcessor.groupInOnePDF(boletos, (new BoletoViewer()).setTemplate(template));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File groupInOnePdfWithTemplate(List<Boleto> boletos, String destPath, String templatePath) {
/*  478 */     checkBoletosList(boletos);
/*  479 */     checkDestPath(destPath);
/*  480 */     checkTemplatePath(templatePath);
/*      */     
/*  482 */     return PdfViewerMultiProcessor.groupInOnePDF(boletos, (new BoletoViewer()).setTemplate(templatePath), new File(destPath));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File groupInOnePdfWithTemplate(List<Boleto> boletos, String destPath, File templateFile) {
/*  508 */     checkBoletosList(boletos);
/*  509 */     checkDestPath(destPath);
/*  510 */     checkTemplateFile(templateFile);
/*      */     
/*  512 */     return PdfViewerMultiProcessor.groupInOnePDF(boletos, (new BoletoViewer()).setTemplate(templateFile), new File(destPath));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File groupInOnePdfWithTemplate(List<Boleto> boletos, File destFile, String templatePath) {
/*  538 */     checkBoletosList(boletos);
/*  539 */     checkDestFile(destFile);
/*  540 */     checkTemplatePath(templatePath);
/*      */     
/*  542 */     return PdfViewerMultiProcessor.groupInOnePDF(boletos, (new BoletoViewer()).setTemplate(templatePath), destFile);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File groupInOnePdfWithTemplate(List<Boleto> boletos, File destFile, File templateFile) {
/*  568 */     checkBoletosList(boletos);
/*  569 */     checkDestFile(destFile);
/*  570 */     checkTemplateFile(templateFile);
/*      */     
/*  572 */     return PdfViewerMultiProcessor.groupInOnePDF(boletos, (new BoletoViewer()).setTemplate(templateFile), destFile);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] groupInOnePdfWithTemplates(Collection<Map.Entry<byte[], List<Boleto>>> templatesAndBoletos) {
/*  592 */     checkTemplateBoletosEntries(templatesAndBoletos);
/*      */     
/*  594 */     return PdfViewerMultiProcessor.groupInOnePDF(templatesAndBoletos);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File groupInOnePdfWithTemplates(Collection<Map.Entry<byte[], List<Boleto>>> templatesAndBoletos, File destFile) {
/*  616 */     checkTemplateBoletosEntries(templatesAndBoletos);
/*  617 */     checkDestFile(destFile);
/*      */ 
/*      */     
/*      */     try {
/*  621 */       return Files.bytesToFile(destFile, PdfViewerMultiProcessor.groupInOnePDF(templatesAndBoletos));
/*      */     }
/*  623 */     catch (Exception e) {
/*      */       
/*  625 */       return (File)Exceptions.throwIllegalStateException("Erro inesperado!", e);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] groupInOnePdfWithTemplates(Map<byte[], List<Boleto>> templatesAndBoletos) {
/*  646 */     checkTemplateBoletosEntries(templatesAndBoletos);
/*      */     
/*  648 */     return groupInOnePdfWithTemplates((Collection)templatesAndBoletos.entrySet());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static File groupInOnePdfWithTemplates(Map<byte[], List<Boleto>> templatesAndBoletos, File destFile) {
/*  671 */     checkTemplateBoletosEntries(templatesAndBoletos);
/*  672 */     checkDestFile(destFile);
/*      */     
/*  674 */     return groupInOnePdfWithTemplates((Collection)templatesAndBoletos.entrySet(), destFile);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<byte[]> onePerPDF(List<Boleto> boletos) {
/*  693 */     checkBoletosList(boletos);
/*      */     
/*  695 */     return PdfViewerMultiProcessor.onePerPDF(boletos);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<File> onePerPDF(List<Boleto> boletos, String destPath) {
/*  729 */     checkBoletosList(boletos);
/*  730 */     checkDestPath(destPath);
/*      */     
/*  732 */     return onePerPDF(boletos, new File(destPath), "", "");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<File> onePerPDF(List<Boleto> boletos, File destDir) {
/*  766 */     checkBoletosList(boletos);
/*  767 */     checkDestDir(destDir);
/*      */     
/*  769 */     return onePerPDF(boletos, destDir, "", "");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<File> onePerPDF(List<Boleto> boletos, String destPath, String prefixo) {
/*  806 */     checkBoletosList(boletos);
/*  807 */     checkDestPath(destPath);
/*      */     
/*  809 */     return onePerPDF(boletos, new File(destPath), prefixo, "");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<File> onePerPDF(List<Boleto> boletos, File destDir, String prefixo) {
/*  846 */     checkBoletosList(boletos);
/*  847 */     checkDestDir(destDir);
/*      */     
/*  849 */     return onePerPDF(boletos, destDir, prefixo, "");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<File> onePerPDF(List<Boleto> boletos, String destPath, String prefixo, String sufixo) {
/*  887 */     checkBoletosList(boletos);
/*  888 */     checkDestPath(destPath);
/*      */     
/*  890 */     return onePerPDF(boletos, new File(destPath), prefixo, sufixo);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<File> onePerPDF(List<Boleto> boletos, File destDir, String prefixo, String sufixo) {
/*  928 */     checkBoletosList(boletos);
/*  929 */     checkDestDir(destDir);
/*      */     
/*  931 */     List<File> files = new ArrayList<File>(boletos.size());
/*      */     
/*  933 */     files.addAll(PdfViewerMultiProcessor.onePerPDF(boletos, destDir, prefixo, sufixo));
/*      */     
/*  935 */     return files;
/*      */   }
/*      */ 
/*      */   
/*      */   public static List<byte[]> onePerPDFWithTemplate(List<Boleto> boletos, String templatePath) {
/*  940 */     checkBoletosList(boletos);
/*  941 */     checkTemplatePath(templatePath);
/*      */     
/*  943 */     return PdfViewerMultiProcessor.onePerPDF(boletos, (new BoletoViewer()).setTemplate(templatePath));
/*      */   }
/*      */ 
/*      */   
/*      */   public static List<byte[]> onePerPDFWithTemplate(List<Boleto> boletos, URL templateUrl) {
/*  948 */     checkBoletosList(boletos);
/*  949 */     checkTemplateFile(templateUrl);
/*      */     
/*  951 */     return PdfViewerMultiProcessor.onePerPDF(boletos, (new BoletoViewer()).setTemplate(templateUrl));
/*      */   }
/*      */ 
/*      */   
/*      */   public static List<byte[]> onePerPDFWithTemplate(List<Boleto> boletos, File templateFile) {
/*  956 */     checkBoletosList(boletos);
/*  957 */     checkTemplateFile(templateFile);
/*      */     
/*  959 */     return PdfViewerMultiProcessor.onePerPDF(boletos, (new BoletoViewer()).setTemplate(templateFile));
/*      */   }
/*      */ 
/*      */   
/*      */   public static List<byte[]> onePerPDFWithTemplate(List<Boleto> boletos, InputStream templateInput) {
/*  964 */     checkBoletosList(boletos);
/*  965 */     checkTemplateFile(templateInput);
/*      */     
/*  967 */     return PdfViewerMultiProcessor.onePerPDF(boletos, (new BoletoViewer()).setTemplate(templateInput));
/*      */   }
/*      */ 
/*      */   
/*      */   public static List<byte[]> onePerPDFWithTemplate(List<Boleto> boletos, byte[] template) {
/*  972 */     checkBoletosList(boletos);
/*  973 */     checkTemplateFile(template);
/*      */     
/*  975 */     return PdfViewerMultiProcessor.onePerPDF(boletos, (new BoletoViewer()).setTemplate(template));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<byte[]> onePerPdfWithTemplates(Collection<Map.Entry<byte[], List<Boleto>>> templatesAndBoletos) {
/*  994 */     checkTemplateBoletosEntries(templatesAndBoletos);
/*      */     
/*  996 */     return PdfViewerMultiProcessor.onePerPDF(templatesAndBoletos);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer setPdfFullCompression(boolean option) {
/* 1025 */     this.pdfViewer.setFullCompression(option);
/*      */     
/* 1027 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer setPdfTitulo(String titulo) {
/* 1041 */     this.pdfViewer.setTitle(titulo);
/*      */     
/* 1043 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer setPdfExibirTitulo(boolean opcao) {
/* 1057 */     this.pdfViewer.setDisplayTitle(opcao);
/*      */     
/* 1059 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer setPdfAutor(String autor) {
/* 1073 */     this.pdfViewer.setAuthor(autor);
/*      */     
/* 1075 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer setPdfAssunto(String assunto) {
/* 1089 */     this.pdfViewer.setSubject(assunto);
/*      */     
/* 1091 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer setPdfPalavrasChave(String palavrasChave) {
/* 1105 */     this.pdfViewer.setKeywords(palavrasChave);
/*      */     
/* 1107 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer setPdfRemoverCampos(boolean opcao) {
/* 1121 */     this.pdfViewer.setRemoveFields(opcao);
/*      */     
/* 1123 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer setTemplate(byte[] template) {
/* 1140 */     checkTemplateFile(template);
/*      */     
/* 1142 */     this.pdfViewer.setTemplate(template);
/*      */     
/* 1144 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer setTemplate(URL templateUrl) {
/* 1161 */     checkTemplateFile(templateUrl);
/*      */     
/* 1163 */     this.pdfViewer.setTemplate(templateUrl);
/*      */     
/* 1165 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer setTemplate(InputStream templateInput) {
/* 1182 */     checkTemplateFile(templateInput);
/*      */     
/* 1184 */     this.pdfViewer.setTemplate(templateInput);
/*      */     
/* 1186 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer setTemplate(String templatePath) {
/* 1203 */     checkTemplatePath(templatePath);
/*      */     
/* 1205 */     this.pdfViewer.setTemplate(templatePath);
/*      */     
/* 1207 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer setTemplate(File templateFile) {
/* 1224 */     checkTemplateFile(templateFile);
/*      */     
/* 1226 */     this.pdfViewer.setTemplate(templateFile);
/*      */     
/* 1228 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer setBoleto(Boleto boleto) {
/* 1245 */     checkBoleto(boleto);
/*      */     
/* 1247 */     updateViewerPDF(boleto);
/*      */     
/* 1249 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BoletoViewer removeTemplate() {
/* 1264 */     String DEFAULT = null;
/*      */     
/* 1266 */     if (Objects.isNotNull(this.pdfViewer)) {
/* 1267 */       this.pdfViewer.setTemplate(DEFAULT);
/*      */     }
/*      */     
/* 1270 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] getTemplate() {
/* 1285 */     return this.pdfViewer.getTemplate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Boleto getBoleto() {
/* 1299 */     return this.pdfViewer.getBoleto();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public File getPdfAsFile(String destPath) {
/* 1315 */     if (log.isDebugEnabled()) {
/* 1316 */       log.debug("documento instance : " + this.pdfViewer);
/*      */     }
/*      */     
/* 1319 */     return this.pdfViewer.getFile(destPath);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public File getPdfAsFile(File destFile) {
/* 1335 */     if (log.isDebugEnabled()) {
/* 1336 */       log.debug("documento instance : " + this.pdfViewer);
/*      */     }
/*      */     
/* 1339 */     return this.pdfViewer.getFile(destFile);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteArrayOutputStream getPdfAsStream() {
/* 1353 */     if (log.isDebugEnabled()) {
/* 1354 */       log.debug("documento instance : " + this.pdfViewer);
/*      */     }
/*      */     
/* 1357 */     return this.pdfViewer.getStream();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] getPdfAsByteArray() {
/* 1372 */     if (log.isDebugEnabled()) {
/* 1373 */       log.debug("documento instance : " + this.pdfViewer);
/*      */     }
/*      */     
/* 1376 */     return this.pdfViewer.getBytes();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void updateViewerPDF(Boleto boleto) {
/* 1390 */     if (Objects.isNotNull(this.pdfViewer)) {
/*      */       
/* 1392 */       this.pdfViewer.setBoleto(boleto);
/*      */     }
/*      */     else {
/*      */       
/* 1396 */       this.pdfViewer = new PdfViewer(boleto);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static void checkDestPath(String path) {
/* 1402 */     checkString(path, "Caminho destinado a geração do(s) arquivo(s) não contém informação!");
/*      */   }
/*      */ 
/*      */   
/*      */   private static void checkTemplatePath(String path) {
/* 1407 */     checkString(path, "Caminho do template não contém informação!");
/*      */   }
/*      */ 
/*      */   
/*      */   private static void checkTemplateFile(Object template) {
/* 1412 */     Objects.checkNotNull(template, "Arquivo de template nulo!");
/*      */   }
/*      */ 
/*      */   
/*      */   private static void checkString(String str, String msg) {
/* 1417 */     Objects.checkNotNull(str);
/* 1418 */     Strings.checkNotBlank(str, msg);
/*      */   }
/*      */ 
/*      */   
/*      */   private static void checkDestDir(File file) {
/* 1423 */     Objects.checkNotNull(file, "Diretório destinado a geração do(s) boleto(s) nulo!");
/* 1424 */     Objects.checkArgument(file.isDirectory(), "Isto não é um diretório válido!");
/*      */   }
/*      */ 
/*      */   
/*      */   private static void checkDestFile(File file) {
/* 1429 */     Objects.checkNotNull(file, "Arquivo destinado a geração do(s) boleto(s) nulo!");
/*      */   }
/*      */ 
/*      */   
/*      */   private static void checkBoleto(Boleto boleto) {
/* 1434 */     Objects.checkNotNull(boleto, "Boleto nulo!");
/*      */   }
/*      */ 
/*      */   
/*      */   private static void checkBoletosList(List<Boleto> boletos) {
/* 1439 */     Objects.checkNotNull(boletos, "Lista de boletos nula!");
/* 1440 */     Collections.checkNotEmpty(boletos, "A Lista de boletos está vazia!");
/*      */   }
/*      */ 
/*      */   
/*      */   private static void checkTemplateBoletosEntries(Collection<Map.Entry<byte[], List<Boleto>>> templatesAndBoletos) {
/* 1445 */     Collections.checkNotEmpty(templatesAndBoletos, "A Coleção de pares: (template,boletos) está vazia!");
/*      */   }
/*      */ 
/*      */   
/*      */   private static void checkTemplateBoletosEntries(Map<byte[], List<Boleto>> templatesAndBoletos) {
/* 1450 */     Collections.checkNotEmpty(templatesAndBoletos, "O Mapa (template,boletos) está vazio!");
/*      */   }
/*      */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\BoletoViewer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */