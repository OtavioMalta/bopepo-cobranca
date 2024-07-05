/*      */ package org.jrimum.bopepo.pdf;
/*      */ 
/*      */ import com.lowagie.text.Image;
/*      */ import com.lowagie.text.pdf.AcroFields;
/*      */ import com.lowagie.text.pdf.PdfBoolean;
/*      */ import com.lowagie.text.pdf.PdfName;
/*      */ import com.lowagie.text.pdf.PdfObject;
/*      */ import com.lowagie.text.pdf.PdfReader;
/*      */ import com.lowagie.text.pdf.PdfStamper;
/*      */ import java.awt.Image;
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.File;
/*      */ import java.io.InputStream;
/*      */ import java.net.URL;
/*      */ import java.util.Calendar;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.WeakHashMap;
/*      */ import org.apache.commons.lang3.StringUtils;
/*      */ import org.apache.log4j.Logger;
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
/*      */ public class PdfDocMix
/*      */ {
/*   74 */   private static final Logger LOG = Logger.getLogger(PdfDocMix.class);
/*      */   
/*      */   private PdfReader reader;
/*      */   
/*      */   private PdfStamper stamper;
/*      */   
/*      */   private AcroFields form;
/*      */   private ByteArrayOutputStream outputStream;
/*   82 */   private Map<Image, Image> imagesInUseMap = new WeakHashMap<Image, Image>();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private byte[] template;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   92 */   private PdfDocInfo docInfo = PdfDocInfo.create();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Map<String, String> txtMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Map<String, Image> imgMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean fullCompression = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean removeFields = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Boolean displayDocTitle;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private PdfDocMix() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PdfDocMix(byte[] template) {
/*  146 */     checkTemplateFile(template);
/*  147 */     setTemplate(template);
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
/*      */   public PdfDocMix(URL templateUrl) {
/*  163 */     checkTemplateFile(templateUrl);
/*  164 */     setTemplate(templateUrl);
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
/*      */   public PdfDocMix(InputStream templateInput) {
/*  180 */     checkTemplateFile(templateInput);
/*  181 */     setTemplate(templateInput);
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
/*      */   public PdfDocMix(String templatePath) {
/*  197 */     checkTemplatePath(templatePath);
/*  198 */     setTemplate(templatePath);
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
/*      */   public PdfDocMix(File templateFile) {
/*  214 */     checkTemplateFile(templateFile);
/*  215 */     setTemplate(templateFile);
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
/*      */   public static PdfDocMix create() {
/*  228 */     return new PdfDocMix();
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
/*      */   public static PdfDocMix createWithTemplate(byte[] template) {
/*  246 */     checkTemplateFile(template);
/*      */     
/*  248 */     return new PdfDocMix(template);
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
/*      */   public static PdfDocMix createWithTemplate(URL templateUrl) {
/*  266 */     checkTemplateFile(templateUrl);
/*      */     
/*  268 */     return new PdfDocMix(templateUrl);
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
/*      */   public static PdfDocMix createWithTemplate(InputStream templateInput) {
/*  286 */     checkTemplateFile(templateInput);
/*      */     
/*  288 */     return new PdfDocMix(templateInput);
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
/*      */   public static PdfDocMix createWithTemplate(String templatePath) {
/*  306 */     checkTemplatePath(templatePath);
/*      */     
/*  308 */     return new PdfDocMix(templatePath);
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
/*      */   public static PdfDocMix createWithTemplate(File templateFile) {
/*  326 */     checkTemplateFile(templateFile);
/*      */     
/*  328 */     return new PdfDocMix(templateFile);
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
/*      */   public PdfDocMix withTemplate(byte[] template) {
/*  346 */     checkTemplateFile(template);
/*      */     
/*  348 */     return setTemplate(template);
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
/*      */   public PdfDocMix withTemplate(URL templateUrl) {
/*  366 */     checkTemplateFile(templateUrl);
/*      */     
/*  368 */     return setTemplate(templateUrl);
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
/*      */   public PdfDocMix withTemplate(InputStream templateInput) {
/*  386 */     checkTemplateFile(templateInput);
/*      */     
/*  388 */     return setTemplate(templateInput);
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
/*      */   public PdfDocMix withTemplate(String templatePath) {
/*  406 */     checkTemplatePath(templatePath);
/*      */     
/*  408 */     return setTemplate(templatePath);
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
/*      */   public PdfDocMix withTemplate(File templateFile) {
/*  426 */     checkTemplateFile(templateFile);
/*      */     
/*  428 */     return setTemplate(templateFile);
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
/*      */   public Map<String, String> getTextFields() {
/*  440 */     return this.txtMap;
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
/*      */   public PdfDocMix putAllTexts(Map<String, String> txtMap) {
/*  457 */     Collections.checkNotEmpty(txtMap, "Campos ausentes!");
/*      */     
/*  459 */     if (Objects.isNull(this.txtMap)) {
/*  460 */       this.txtMap = txtMap;
/*      */     } else {
/*  462 */       this.txtMap.putAll(txtMap);
/*      */     } 
/*      */     
/*  465 */     return this;
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
/*      */   public PdfDocMix put(String name, String value) {
/*  483 */     Strings.checkNotBlank(name, "Nome do campo ausente!");
/*      */     
/*  485 */     if (Objects.isNull(this.txtMap)) {
/*  486 */       this.txtMap = new WeakHashMap<String, String>();
/*      */     }
/*      */     
/*  489 */     this.txtMap.put(name, value);
/*      */     
/*  491 */     return this;
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
/*      */   public Map<String, Image> getImageFields() {
/*  503 */     return this.imgMap;
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
/*      */   public PdfDocMix putAllImages(Map<String, Image> imgMap) {
/*  520 */     Collections.checkNotEmpty(imgMap, "Campos ausentes!");
/*      */     
/*  522 */     if (Objects.isNull(this.imgMap)) {
/*  523 */       this.imgMap = imgMap;
/*      */     } else {
/*  525 */       this.imgMap.putAll(imgMap);
/*      */     } 
/*      */     
/*  528 */     return this;
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
/*      */   public PdfDocMix put(String name, Image value) {
/*  546 */     Strings.checkNotBlank(name, "Nome do campo ausente!");
/*      */     
/*  548 */     if (Objects.isNull(this.imgMap)) {
/*  549 */       this.imgMap = new WeakHashMap<String, Image>();
/*      */     }
/*      */     
/*  552 */     this.imgMap.put(name, value);
/*      */     
/*  554 */     return this;
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
/*      */   public PdfDocMix withFullCompression(boolean option) {
/*  575 */     this.fullCompression = option;
/*  576 */     return this;
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
/*      */   public PdfDocMix removeFields(boolean option) {
/*  595 */     this.removeFields = option;
/*  596 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PdfDocMix withTitle(String title) {
/*  607 */     this.docInfo.title(title);
/*  608 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PdfDocMix withAuthor(String author) {
/*  619 */     this.docInfo.author(author);
/*  620 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PdfDocMix withSubject(String subject) {
/*  631 */     this.docInfo.subject(subject);
/*  632 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PdfDocMix withKeywords(String keywords) {
/*  643 */     this.docInfo.keywords(keywords);
/*  644 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PdfDocMix withCreator(String creator) {
/*  655 */     this.docInfo.creator(creator);
/*  656 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PdfDocMix withCreation(Calendar date) {
/*  667 */     this.docInfo.creation(date);
/*  668 */     return this;
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
/*      */   public PdfDocMix withDocInfo(PdfDocInfo docInfo) {
/*  690 */     Objects.checkNotNull(docInfo, "Valor null para docInfo não permitido!");
/*      */     
/*  692 */     this.docInfo = docInfo;
/*      */     
/*  694 */     return this;
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
/*      */   public PdfDocMix withDisplayDocTilteOption(boolean option) {
/*  710 */     this.displayDocTitle = Boolean.valueOf(option);
/*      */     
/*  712 */     return this;
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
/*      */   public File toFile(String destPath) {
/*  727 */     checkDestPath(destPath);
/*      */     
/*  729 */     return toFile(new File(destPath));
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
/*      */   public File toFile(URL destURL) {
/*  744 */     checkDestURL(destURL);
/*      */ 
/*      */     
/*      */     try {
/*  748 */       return toFile(new File(destURL.toURI()));
/*      */     }
/*  750 */     catch (Exception e) {
/*      */       
/*  752 */       LOG.error("Erro durante a criação do arquivo! " + e.getLocalizedMessage(), e);
/*      */ 
/*      */ 
/*      */       
/*  756 */       return (File)Exceptions.throwIllegalStateException("Erro ao tentar criar arquivo! Causado por " + e.getLocalizedMessage(), e);
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
/*      */   public File toFile(File destFile) {
/*  776 */     checkDestFile(destFile);
/*      */ 
/*      */     
/*      */     try {
/*  780 */       process();
/*      */       
/*  782 */       return Files.bytesToFile(destFile, this.outputStream.toByteArray());
/*      */     }
/*  784 */     catch (Exception e) {
/*      */       
/*  786 */       LOG.error("Erro durante a criação do arquivo! " + e.getLocalizedMessage(), e);
/*      */ 
/*      */ 
/*      */       
/*  790 */       return (File)Exceptions.throwIllegalStateException("Erro ao tentar criar arquivo! Causado por " + e.getLocalizedMessage(), e);
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
/*      */   public ByteArrayOutputStream toStream() {
/*      */     try {
/*  808 */       process();
/*      */       
/*  810 */       return Files.bytesToStream(this.outputStream.toByteArray());
/*      */     }
/*  812 */     catch (Exception e) {
/*      */       
/*  814 */       LOG.error("Erro durante a criação do stream! " + e.getLocalizedMessage(), e);
/*      */ 
/*      */ 
/*      */       
/*  818 */       return (ByteArrayOutputStream)Exceptions.throwIllegalStateException("Erro durante a criação do stream! Causado por " + e.getLocalizedMessage(), e);
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
/*      */   public byte[] toBytes() {
/*      */     try {
/*  836 */       process();
/*      */       
/*  838 */       return this.outputStream.toByteArray();
/*      */     }
/*  840 */     catch (Exception e) {
/*      */       
/*  842 */       LOG.error("Erro durante a criação do array de bytes! " + e.getLocalizedMessage(), e);
/*      */ 
/*      */ 
/*      */       
/*  846 */       return (byte[])Exceptions.throwIllegalStateException("Erro durante a criação do array de bytes! Causado por " + e.getLocalizedMessage(), e);
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
/*      */   public byte[] getTemplate() {
/*  862 */     return (byte[])this.template.clone();
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
/*      */   private PdfDocMix setTemplate(byte[] template) {
/*  876 */     this.template = template;
/*  877 */     return this;
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
/*      */   private PdfDocMix setTemplate(URL templateUrl) {
/*      */     try {
/*  892 */       setTemplate(templateUrl.openStream());
/*  893 */       return this;
/*  894 */     } catch (Exception e) {
/*  895 */       return (PdfDocMix)Exceptions.throwIllegalStateException(e);
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
/*      */   private PdfDocMix setTemplate(InputStream templateInput) {
/*      */     try {
/*  911 */       setTemplate(Files.toByteArray(templateInput));
/*  912 */       return this;
/*  913 */     } catch (Exception e) {
/*  914 */       return (PdfDocMix)Exceptions.throwIllegalStateException(e);
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
/*      */   private PdfDocMix setTemplate(String templatePath) {
/*  929 */     setTemplate(new File(templatePath));
/*  930 */     return this;
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
/*      */   private PdfDocMix setTemplate(File templateFile) {
/*      */     try {
/*  945 */       setTemplate(Files.fileToBytes(templateFile));
/*  946 */       return this;
/*  947 */     } catch (Exception e) {
/*  948 */       return (PdfDocMix)Exceptions.throwIllegalStateException(e);
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
/*      */   private boolean isFullCompression() {
/*  963 */     return this.fullCompression;
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
/*      */   private boolean isRemoveFields() {
/*  977 */     return this.removeFields;
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
/*      */   private void process() {
/*  992 */     init();
/*  993 */     fillFields();
/*  994 */     end();
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
/*      */   private void init() {
/*      */     try {
/* 1007 */       this.reader = new PdfReader(getTemplate());
/*      */       
/* 1009 */       this.outputStream = new ByteArrayOutputStream();
/*      */       
/* 1011 */       this.stamper = new PdfStamper(this.reader, this.outputStream);
/*      */       
/* 1013 */       String JRIMUM = "jrimum.org/bopepo";
/*      */       
/* 1015 */       String creator = this.docInfo.creator();
/*      */       
/* 1017 */       if (StringUtils.isBlank(creator)) {
/* 1018 */         withCreator("jrimum.org/bopepo");
/*      */       } else {
/* 1020 */         withCreator(creator + " by (" + "jrimum.org/bopepo" + ")");
/*      */       } 
/*      */       
/* 1023 */       if (Objects.isNull(this.docInfo.creation())) {
/* 1024 */         this.docInfo.creation(Calendar.getInstance());
/*      */       }
/*      */       
/* 1027 */       this.stamper.setMoreInfo((HashMap)this.docInfo.toMap());
/*      */       
/* 1029 */       if (Objects.isNotNull(this.displayDocTitle)) {
/* 1030 */         this.stamper.addViewerPreference(PdfName.DISPLAYDOCTITLE, this.displayDocTitle.booleanValue() ? (PdfObject)PdfBoolean.PDFTRUE : (PdfObject)PdfBoolean.PDFFALSE);
/*      */       }
/*      */       
/* 1033 */       this.form = this.stamper.getAcroFields();
/*      */     }
/* 1035 */     catch (Exception e) {
/*      */       
/* 1037 */       Exceptions.throwIllegalStateException(e);
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
/*      */   private void fillFields() {
/* 1049 */     setTextFields();
/* 1050 */     setImageFields();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void setTextFields() {
/* 1061 */     if (Collections.hasElement(this.txtMap)) {
/* 1062 */       for (Map.Entry<String, String> e : this.txtMap.entrySet()) {
/*      */         try {
/* 1064 */           this.form.setField(e.getKey(), e.getValue());
/* 1065 */         } catch (Exception ex) {
/* 1066 */           Exceptions.throwIllegalStateException(ex);
/*      */         } 
/*      */       } 
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
/*      */   private void setImageFields() {
/* 1080 */     if (Collections.hasElement(this.imgMap)) {
/* 1081 */       for (Map.Entry<String, Image> e : this.imgMap.entrySet()) {
/* 1082 */         setImage(e.getKey(), e.getValue());
/*      */       }
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
/*      */   private void setImage(String fieldName, Image image) {
/* 1099 */     if (StringUtils.isNotBlank(fieldName)) {
/*      */       
/* 1101 */       float[] posImgField = this.form.getFieldPositions(fieldName);
/*      */       
/* 1103 */       if (Objects.isNotNull(posImgField)) {
/*      */         try {
/* 1105 */           PDFs.changeFieldToImage(this.stamper, posImgField, getPdfImage(image));
/* 1106 */         } catch (Exception e) {
/* 1107 */           Exceptions.throwIllegalStateException(e);
/*      */         } 
/*      */       } else {
/* 1110 */         LOG.warn("Posicionamento do campo de imagem nao encontrado! CAMPO: " + fieldName);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Image getPdfImage(Image image) {
/* 1117 */     Image pdfImage = this.imagesInUseMap.get(image);
/*      */     
/* 1119 */     if (Objects.isNull(pdfImage)) {
/*      */       try {
/* 1121 */         pdfImage = Image.getInstance(image, null);
/* 1122 */         this.imagesInUseMap.put(image, pdfImage);
/* 1123 */       } catch (Exception ex) {
/* 1124 */         Exceptions.throwIllegalStateException(ex);
/*      */       } 
/*      */     }
/* 1127 */     return pdfImage;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void end() {
/* 1138 */     if (isFullCompression()) {
/* 1139 */       this.stamper.setFullCompression();
/*      */     }
/*      */     
/* 1142 */     if (isRemoveFields()) {
/* 1143 */       this.stamper.setFreeTextFlattening(true);
/* 1144 */       this.stamper.setFormFlattening(true);
/* 1145 */       this.reader.removeFields();
/*      */     } else {
/* 1147 */       this.stamper.setFreeTextFlattening(false);
/* 1148 */       this.stamper.setFormFlattening(false);
/*      */     } 
/*      */     
/* 1151 */     this.reader.consolidateNamedDestinations();
/*      */     
/* 1153 */     this.reader.eliminateSharedStreams();
/*      */ 
/*      */     
/*      */     try {
/* 1157 */       this.outputStream.flush();
/*      */       
/* 1159 */       this.outputStream.close();
/* 1160 */       this.reader.close();
/* 1161 */       this.stamper.close();
/*      */     }
/* 1163 */     catch (Exception e) {
/* 1164 */       Exceptions.throwIllegalStateException(e);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static void checkDestPath(String path) {
/* 1170 */     checkString(path, "Caminho destinado a geração do(s) arquivo(s) não contém informação!");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void checkTemplatePath(String path) {
/* 1176 */     checkString(path, "Caminho do template não contém informação!");
/*      */   }
/*      */ 
/*      */   
/*      */   private static void checkTemplateFile(Object template) {
/* 1181 */     Objects.checkNotNull(template, "Arquivo de template nulo!");
/*      */   }
/*      */ 
/*      */   
/*      */   private static void checkString(String str, String msg) {
/* 1186 */     Objects.checkNotNull(str);
/* 1187 */     Strings.checkNotBlank(str, msg);
/*      */   }
/*      */ 
/*      */   
/*      */   private static void checkDestURL(URL url) {
/* 1192 */     Objects.checkNotNull(url, "URL destinada a geração do(s) documentos(s) nula!");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void checkDestFile(File file) {
/* 1198 */     Objects.checkNotNull(file, "Arquivo destinado a geração do(s) documentos(s) nulo!");
/*      */   }
/*      */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\pdf\PdfDocMix.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */