/*     */ package org.jrimum.bopepo.view;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import org.apache.commons.lang3.builder.ToStringBuilder;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.jrimum.bopepo.Boleto;
/*     */ import org.jrimum.bopepo.pdf.Files;
/*     */ import org.jrimum.bopepo.pdf.PdfDocMix;
/*     */ import org.jrimum.bopepo.view.info.BoletoInfoViewBuilder;
/*     */ import org.jrimum.utilix.Exceptions;
/*     */ import org.jrimum.utilix.Objects;
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
/*     */ class PdfViewer
/*     */ {
/*  63 */   private static Logger log = Logger.getLogger(PdfViewer.class);
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
/*  79 */   private final ResourceBundle resourceBundle = new ResourceBundle();
/*  80 */   private PdfDocMix doc = PdfDocMix.create();
/*     */ 
/*     */   
/*     */   private Boleto boleto;
/*     */ 
/*     */   
/*     */   private byte[] template;
/*     */ 
/*     */   
/*     */   protected PdfViewer() {}
/*     */ 
/*     */   
/*     */   protected PdfViewer(Boleto boleto) {
/*  93 */     this();
/*     */     
/*  95 */     this.boleto = boleto;
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
/*     */   protected PdfViewer(Boleto boleto, byte[] template) {
/* 109 */     this(boleto);
/*     */     
/* 111 */     setTemplate(template);
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
/*     */   protected File getFile(String destPath) {
/* 127 */     return getFile(new File(destPath));
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
/*     */   protected File getFile(File destFile) {
/*     */     try {
/* 146 */       processarPdf();
/*     */       
/* 148 */       return this.doc.toFile(destFile);
/*     */     }
/* 150 */     catch (Exception e) {
/*     */       
/* 152 */       log.error("Erro durante a criação do arquivo! " + e.getLocalizedMessage(), e);
/*     */       
/* 154 */       return (File)Exceptions.throwIllegalStateException("Erro ao tentar criar arquivo! Causado por " + e.getLocalizedMessage(), e);
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
/*     */   protected ByteArrayOutputStream getStream() {
/*     */     try {
/* 170 */       processarPdf();
/*     */       
/* 172 */       return this.doc.toStream();
/*     */     }
/* 174 */     catch (Exception e) {
/*     */       
/* 176 */       log.error("Erro durante a criação do stream! " + e.getLocalizedMessage(), e);
/*     */       
/* 178 */       return (ByteArrayOutputStream)Exceptions.throwIllegalStateException("Erro durante a criação do stream! Causado por " + e.getLocalizedMessage(), e);
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
/*     */   protected byte[] getBytes() {
/*     */     try {
/* 194 */       processarPdf();
/*     */       
/* 196 */       return this.doc.toBytes();
/*     */     }
/* 198 */     catch (Exception e) {
/*     */       
/* 200 */       log.error("Erro durante a criação do array de bytes! " + e.getLocalizedMessage(), e);
/*     */       
/* 202 */       return (byte[])Exceptions.throwIllegalStateException("Erro durante a criação do array de bytes! Causado por " + e.getLocalizedMessage(), e);
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
/*     */   protected byte[] getTemplate() {
/* 215 */     return this.template;
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
/*     */   protected void setTemplate(byte[] template) {
/* 227 */     this.template = template;
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
/*     */   protected void setTemplate(URL templateUrl) {
/*     */     try {
/* 240 */       setTemplate(templateUrl.openStream());
/* 241 */     } catch (IOException e) {
/* 242 */       Exceptions.throwIllegalStateException(e);
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
/*     */   protected void setTemplate(InputStream templateInput) {
/*     */     try {
/* 256 */       setTemplate(Files.toByteArray(templateInput));
/* 257 */     } catch (IOException e) {
/* 258 */       Exceptions.throwIllegalStateException(e);
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
/*     */   protected void setTemplate(String templatePath) {
/* 271 */     setTemplate(new File(templatePath));
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
/*     */   protected void setTemplate(File templateFile) {
/*     */     try {
/* 284 */       setTemplate(Files.fileToBytes(templateFile));
/* 285 */     } catch (IOException e) {
/* 286 */       Exceptions.throwIllegalStateException(e);
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
/*     */   protected void setFullCompression(boolean option) {
/* 306 */     this.doc.withFullCompression(option);
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
/*     */   protected void setTitle(String title) {
/* 318 */     this.doc.withTitle(title);
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
/*     */   protected void setDisplayTitle(boolean option) {
/* 330 */     this.doc.withDisplayDocTilteOption(option);
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
/*     */   protected void setAuthor(String author) {
/* 342 */     this.doc.withAuthor(author);
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
/*     */   protected void setSubject(String subject) {
/* 354 */     this.doc.withSubject(subject);
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
/*     */   protected void setKeywords(String keywords) {
/* 366 */     this.doc.withKeywords(keywords);
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
/*     */   protected void setRemoveFields(boolean option) {
/* 378 */     this.doc.removeFields(option);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Boleto getBoleto() {
/* 388 */     return this.boleto;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setBoleto(Boleto boleto) {
/* 399 */     this.boleto = boleto;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void processarPdf() {
/* 410 */     byte[] template = null;
/*     */     
/* 412 */     if (isTemplateFromResource()) {
/* 413 */       template = getTemplateFromResource();
/*     */     } else {
/* 415 */       template = getTemplate();
/*     */     } 
/*     */     
/* 418 */     this.doc.withTemplate(template);
/*     */     
/* 420 */     BoletoInfoViewBuilder builder = (new BoletoInfoViewBuilder(this.resourceBundle, this.boleto)).build();
/*     */     
/* 422 */     this.doc.putAllTexts(builder.texts());
/* 423 */     this.doc.putAllImages(builder.images());
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
/*     */   private byte[] getTemplateFromResource() {
/* 437 */     if (this.boleto.getTitulo().hasSacadorAvalista())
/*     */     {
/* 439 */       return this.resourceBundle.getTemplateComSacadorAvalista();
/*     */     }
/*     */ 
/*     */     
/* 443 */     return this.resourceBundle.getTemplateSemSacadorAvalista();
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
/*     */   private boolean isTemplateFromResource() {
/* 459 */     return Objects.isNull(getTemplate());
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
/*     */   public String toString() {
/* 471 */     ToStringBuilder tsb = new ToStringBuilder(this);
/*     */     
/* 473 */     tsb.append(this.boleto);
/*     */     
/* 475 */     return tsb.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\view\PdfViewer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */