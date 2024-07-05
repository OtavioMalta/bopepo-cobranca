/*     */ package org.jrimum.bopepo.pdf;
/*     */ 
/*     */ import com.lowagie.text.pdf.PdfDate;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public class PdfDocInfo
/*     */ {
/*     */   private static final String DOC_TITLE = "Title";
/*     */   private static final String DOC_AUTHOR = "Author";
/*     */   private static final String DOC_SUBJECT = "Subject";
/*     */   private static final String DOC_KEYWORDS = "Keywords";
/*     */   private static final String DOC_CREATOR = "Creator";
/*     */   private static final String DOC_CREATION_DATE = "CreationDate";
/*     */   private static final String DOC_MODIFACTION_DATE = "ModDate";
/*     */   private static final String DOC_PRODUCER = "Producer";
/*     */   private final Map<String, String> docInfo;
/*     */   
/*     */   private PdfDocInfo() {
/* 101 */     Exceptions.throwIllegalStateException("Estado não permitido!");
/* 102 */     this.docInfo = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PdfDocInfo(Map<String, String> info) {
/* 112 */     Objects.checkNotNull(info);
/*     */     
/* 114 */     this.docInfo = info;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PdfDocInfo create() {
/* 124 */     return new PdfDocInfo(new HashMap<String, String>(8));
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
/*     */   public static PdfDocInfo create(Map<String, String> info) {
/* 136 */     Objects.checkNotNull(info, "INFO INVÁLIDA!");
/*     */     
/* 138 */     return new PdfDocInfo(info);
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
/*     */   public PdfDocInfo title(String title) {
/* 150 */     if (Objects.isNotNull(title)) {
/* 151 */       this.docInfo.put("Title", title);
/*     */     }
/*     */     
/* 154 */     return this;
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
/*     */   public PdfDocInfo author(String author) {
/* 166 */     if (Objects.isNotNull(author)) {
/* 167 */       this.docInfo.put("Author", author);
/*     */     }
/*     */     
/* 170 */     return this;
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
/*     */   public PdfDocInfo subject(String subject) {
/* 182 */     if (Objects.isNotNull(subject)) {
/* 183 */       this.docInfo.put("Subject", subject);
/*     */     }
/*     */     
/* 186 */     return this;
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
/*     */   public PdfDocInfo keywords(String keywords) {
/* 198 */     if (Objects.isNotNull(keywords)) {
/* 199 */       this.docInfo.put("Keywords", keywords);
/*     */     }
/*     */     
/* 202 */     return this;
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
/*     */   public PdfDocInfo creator(String creator) {
/* 214 */     if (Objects.isNotNull(creator)) {
/* 215 */       this.docInfo.put("Creator", creator);
/*     */     }
/*     */     
/* 218 */     return this;
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
/*     */   public PdfDocInfo creation(Calendar date) {
/* 234 */     Objects.checkNotNull(date, "Valor null não permitido para data de criação do documento!");
/*     */     
/* 236 */     this.docInfo.put("CreationDate", PdfDateConverter.convert(date));
/*     */     
/* 238 */     return this;
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
/*     */   public PdfDocInfo modification(Calendar date) {
/* 254 */     Objects.checkNotNull(date, "Valor null não permitido para data de modificação do documento!"); Objects.checkNotNull(date);
/*     */     
/* 256 */     this.docInfo.put("ModDate", PdfDateConverter.convert(date));
/*     */     
/* 258 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String title() {
/* 266 */     return this.docInfo.get("Title");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String author() {
/* 274 */     return this.docInfo.get("Author");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String subject() {
/* 282 */     return this.docInfo.get("Subject");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String keywords() {
/* 290 */     return this.docInfo.get("Keywords");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String creator() {
/* 298 */     return this.docInfo.get("Creator");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String creationRaw() {
/* 309 */     return this.docInfo.get("CreationDate");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Calendar creation() {
/* 317 */     return PdfDate.decode(this.docInfo.get("CreationDate"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String modificationRaw() {
/* 328 */     return this.docInfo.get("ModDate");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Calendar modification() {
/* 336 */     return PdfDate.decode(this.docInfo.get("ModDate"));
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
/*     */   public String producer() {
/* 352 */     return this.docInfo.get("Producer");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> toMap() {
/* 362 */     return new HashMap<String, String>(this.docInfo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 372 */     int prime = 31;
/* 373 */     int result = 1;
/* 374 */     result = 31 * result + ((this.docInfo == null) ? 0 : this.docInfo.hashCode());
/* 375 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 385 */     if (this == obj)
/* 386 */       return true; 
/* 387 */     if (obj == null)
/* 388 */       return false; 
/* 389 */     if (getClass() != obj.getClass())
/* 390 */       return false; 
/* 391 */     PdfDocInfo other = (PdfDocInfo)obj;
/* 392 */     if (this.docInfo == null) {
/* 393 */       if (other.docInfo != null)
/* 394 */         return false; 
/* 395 */     } else if (!this.docInfo.equals(other.docInfo)) {
/* 396 */       return false;
/* 397 */     }  return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 407 */     return "PdfDocInfo [docInfo=" + this.docInfo + "]";
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\pdf\PdfDocInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */