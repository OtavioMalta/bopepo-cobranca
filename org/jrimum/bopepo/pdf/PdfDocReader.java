/*     */ package org.jrimum.bopepo.pdf;
/*     */ 
/*     */ import com.lowagie.text.pdf.AcroFields;
/*     */ import com.lowagie.text.pdf.PdfReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.jrimum.utilix.Collections;
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
/*     */ public class PdfDocReader
/*     */ {
/*     */   private final PdfReader reader;
/*     */   private final AcroFields form;
/*     */   private final PdfDocInfo docInfo;
/*     */   
/*     */   private PdfDocReader() {
/*  68 */     Exceptions.throwIllegalStateException("Estado não permitido!");
/*  69 */     this.reader = null;
/*  70 */     this.form = null;
/*  71 */     this.docInfo = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PdfDocReader(byte[] pdfIn) {
/*  82 */     PdfReader r = null;
/*     */     try {
/*  84 */       r = new PdfReader(pdfIn);
/*  85 */     } catch (Exception e) {
/*  86 */       Exceptions.throwIllegalStateException(e);
/*     */     } 
/*  88 */     this.reader = r;
/*  89 */     this.form = this.reader.getAcroFields();
/*  90 */     this.docInfo = PdfDocInfo.create(this.reader.getInfo());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PdfDocReader(InputStream is) {
/* 101 */     PdfReader r = null;
/*     */     try {
/* 103 */       r = new PdfReader(is);
/* 104 */     } catch (Exception e) {
/* 105 */       Exceptions.throwIllegalStateException(e);
/*     */     } 
/* 107 */     this.reader = r;
/* 108 */     this.form = this.reader.getAcroFields();
/* 109 */     this.docInfo = PdfDocInfo.create(this.reader.getInfo());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PdfDocReader(URL url) {
/* 120 */     PdfReader r = null;
/*     */     try {
/* 122 */       r = new PdfReader(url);
/* 123 */     } catch (Exception e) {
/* 124 */       Exceptions.throwIllegalStateException(e);
/*     */     } 
/* 126 */     this.reader = r;
/* 127 */     this.form = this.reader.getAcroFields();
/* 128 */     this.docInfo = PdfDocInfo.create(this.reader.getInfo());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PdfDocReader(File file) {
/* 139 */     PdfReader r = null;
/*     */     try {
/* 141 */       r = new PdfReader(new FileInputStream(file));
/* 142 */     } catch (Exception e) {
/* 143 */       Exceptions.throwIllegalStateException(e);
/*     */     } 
/* 145 */     this.reader = r;
/* 146 */     this.form = this.reader.getAcroFields();
/* 147 */     this.docInfo = PdfDocInfo.create(this.reader.getInfo());
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
/*     */   public PdfDocReader(byte[] pdfIn, byte[] ownerPassword) {
/* 160 */     PdfReader r = null;
/*     */     try {
/* 162 */       r = new PdfReader(pdfIn, ownerPassword);
/* 163 */     } catch (Exception e) {
/* 164 */       Exceptions.throwIllegalStateException(e);
/*     */     } 
/* 166 */     this.reader = r;
/* 167 */     this.form = this.reader.getAcroFields();
/* 168 */     this.docInfo = PdfDocInfo.create(this.reader.getInfo());
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
/*     */   public PdfDocReader(InputStream is, byte[] ownerPassword) {
/* 181 */     PdfReader r = null;
/*     */     try {
/* 183 */       r = new PdfReader(is, ownerPassword);
/* 184 */     } catch (Exception e) {
/* 185 */       Exceptions.throwIllegalStateException(e);
/*     */     } 
/* 187 */     this.reader = r;
/* 188 */     this.form = this.reader.getAcroFields();
/* 189 */     this.docInfo = PdfDocInfo.create(this.reader.getInfo());
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
/*     */   public PdfDocReader(URL url, byte[] ownerPassword) {
/* 202 */     PdfReader r = null;
/*     */     try {
/* 204 */       r = new PdfReader(url, ownerPassword);
/* 205 */     } catch (Exception e) {
/* 206 */       Exceptions.throwIllegalStateException(e);
/*     */     } 
/* 208 */     this.reader = r;
/* 209 */     this.form = this.reader.getAcroFields();
/* 210 */     this.docInfo = PdfDocInfo.create(this.reader.getInfo());
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
/*     */   public PdfDocReader(File file, byte[] ownerPassword) {
/* 223 */     PdfReader r = null;
/*     */     try {
/* 225 */       r = new PdfReader(new FileInputStream(file), ownerPassword);
/* 226 */     } catch (Exception e) {
/* 227 */       Exceptions.throwIllegalStateException(e);
/*     */     } 
/* 229 */     this.reader = r;
/* 230 */     this.form = this.reader.getAcroFields();
/* 231 */     this.docInfo = PdfDocInfo.create(this.reader.getInfo());
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
/*     */   public String getField(String name) {
/* 244 */     return this.form.getField(name);
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
/*     */   public Collection<String> getFieldsNames() {
/* 256 */     return this.form.getFields().keySet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> getFields() {
/* 267 */     Collection<String> names = getFieldsNames();
/*     */     
/* 269 */     if (Collections.hasElement(names)) {
/* 270 */       Map<String, String> fields = new HashMap<String, String>(names.size());
/* 271 */       for (String name : names) {
/* 272 */         fields.put(name, getField(name));
/*     */       }
/* 274 */       return fields;
/*     */     } 
/*     */     
/* 277 */     return Collections.emptyMap();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PdfDocInfo getInfo() {
/* 287 */     return this.docInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*     */     try {
/* 295 */       this.reader.close();
/* 296 */     } catch (Exception e) {
/* 297 */       Exceptions.throwIllegalStateException(e);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\pdf\PdfDocReader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */