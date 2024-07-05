/*     */ package org.jrimum.bopepo.view;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.jrimum.bopepo.Boleto;
/*     */ import org.jrimum.bopepo.pdf.Files;
/*     */ import org.jrimum.bopepo.pdf.PDFs;
/*     */ import org.jrimum.utilix.Exceptions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PdfViewerMultiProcessor
/*     */ {
/*     */   protected static byte[] groupInOnePDF(List<Boleto> boletos, BoletoViewer boletoViewer) {
/*  71 */     byte[] file = null;
/*     */     
/*  73 */     List<byte[]> boletosEmBytes = (List)new ArrayList<byte>(boletos.size());
/*     */     
/*  75 */     for (Boleto bop : boletos) {
/*  76 */       boletosEmBytes.add(boletoViewer.setBoleto(bop).getPdfAsByteArray());
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/*  81 */       file = PDFs.mergeFiles(boletosEmBytes);
/*     */       
/*  83 */       boletosEmBytes.clear();
/*     */       
/*  85 */       return file;
/*     */     }
/*  87 */     catch (Exception e) {
/*     */       
/*  89 */       return (byte[])Exceptions.throwIllegalStateException("Erro durante geração do PDF! Causado por " + e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static File groupInOnePDF(List<Boleto> boletos, BoletoViewer boletoViewer, File fileDest) {
/*     */     try {
/* 111 */       return Files.bytesToFile(fileDest, groupInOnePDF(boletos, boletoViewer));
/*     */     }
/* 113 */     catch (Exception e) {
/*     */       
/* 115 */       return (File)Exceptions.throwIllegalStateException("Erro durante geração do PDF! Causado por " + e.getLocalizedMessage(), e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static byte[] groupInOnePDF(Collection<Map.Entry<byte[], List<Boleto>>> templatesAndBoletos) {
/* 133 */     byte[] file = null;
/*     */     
/* 135 */     List<byte[]> toMerge = (List)new ArrayList<byte>(templatesAndBoletos.size());
/*     */     
/* 137 */     BoletoViewer viewer = new BoletoViewer();
/*     */     
/* 139 */     for (Map.Entry<byte[], List<Boleto>> entry : templatesAndBoletos)
/*     */     {
/* 141 */       toMerge.add(groupInOnePDF(entry.getValue(), viewer.setTemplate(entry.getKey())));
/*     */     }
/*     */     
/* 144 */     file = PDFs.mergeFiles(toMerge);
/*     */     
/* 146 */     toMerge.clear();
/*     */     
/* 148 */     return file;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static List<File> onePerPDF(List<Boleto> boletos, File destDir, String prefixo, String sufixo) {
/* 184 */     List<File> arquivos = new ArrayList<File>(boletos.size());
/* 185 */     BoletoViewer bv = new BoletoViewer();
/* 186 */     int cont = 1;
/*     */     
/* 188 */     for (Boleto bop : boletos) {
/* 189 */       arquivos.add(bv.setBoleto(bop).getPdfAsFile(destDir.getAbsolutePath() + File.separator + prefixo + cont++ + sufixo + ".pdf"));
/*     */     }
/*     */     
/* 192 */     return arquivos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static List<byte[]> onePerPDF(List<Boleto> boletos) {
/* 209 */     return onePerPDF(boletos, new BoletoViewer());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static List<byte[]> onePerPDF(List<Boleto> boletos, BoletoViewer boletoViewer) {
/* 228 */     List<byte[]> arquivos = (List)new ArrayList<byte>(boletos.size());
/*     */     
/* 230 */     for (Boleto bop : boletos) {
/* 231 */       arquivos.add(boletoViewer.setBoleto(bop).getPdfAsByteArray());
/*     */     }
/*     */     
/* 234 */     return arquivos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static List<byte[]> onePerPDF(Collection<Map.Entry<byte[], List<Boleto>>> templatesAndBoletos) {
/* 252 */     List<byte[]> boletos = (List)new ArrayList<byte>(templatesAndBoletos.size());
/*     */     
/* 254 */     BoletoViewer viewer = new BoletoViewer();
/*     */     
/* 256 */     for (Map.Entry<byte[], List<Boleto>> entry : templatesAndBoletos)
/*     */     {
/* 258 */       boletos.addAll(onePerPDF(entry.getValue(), viewer.setTemplate(entry.getKey())));
/*     */     }
/*     */     
/* 261 */     return boletos;
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\PdfViewerMultiProcessor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */