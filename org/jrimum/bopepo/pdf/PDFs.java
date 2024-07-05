/*     */ package org.jrimum.bopepo.pdf;
/*     */ 
/*     */ import com.lowagie.text.Document;
/*     */ import com.lowagie.text.DocumentException;
/*     */ import com.lowagie.text.Image;
/*     */ import com.lowagie.text.pdf.PdfCopy;
/*     */ import com.lowagie.text.pdf.PdfReader;
/*     */ import com.lowagie.text.pdf.PdfStamper;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.util.Collection;
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
/*     */ 
/*     */ 
/*     */ public class PDFs
/*     */ {
/*     */   public static PdfRectangle changeFieldToImage(PdfStamper stamper, float[] positions, Image image) throws DocumentException {
/*  73 */     PdfRectangle rect = new PdfRectangle(positions);
/*     */     
/*  75 */     return changeFieldToImage(stamper, rect, image);
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
/*     */   public static PdfRectangle changeFieldToImage(PdfStamper stamper, PdfRectangle rect, Image image) throws DocumentException {
/*  96 */     image.scaleAbsolute(rect.getWidth(), rect.getHeight());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 105 */     image.setAbsolutePosition(rect.getLowerLeftX() + (rect.getWidth() - image.getScaledWidth()) / 2.0F, rect.getLowerLeftY() + (rect.getHeight() - image.getScaledHeight()) / 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 110 */     stamper.getOverContent(rect.getPage()).addImage(image);
/*     */     
/* 112 */     return rect;
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
/*     */   public static byte[] mergeFiles(Collection<byte[]> pdfFiles) {
/* 126 */     return mergeFiles(pdfFiles, null);
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
/*     */   public static byte[] mergeFiles(Collection<byte[]> pdfFiles, PdfDocInfo info) {
/*     */     try {
/* 146 */       ByteArrayOutputStream byteOS = new ByteArrayOutputStream();
/*     */       
/* 148 */       Document document = new Document();
/*     */       
/* 150 */       PdfCopy copy = new PdfCopy(document, byteOS);
/*     */       
/* 152 */       document.open();
/*     */       
/* 154 */       for (byte[] f : pdfFiles) {
/*     */         
/* 156 */         PdfReader reader = new PdfReader(f);
/*     */         
/* 158 */         for (int page = 1; page <= reader.getNumberOfPages(); page++)
/*     */         {
/* 160 */           copy.addPage(copy.getImportedPage(reader, page));
/*     */         }
/*     */         
/* 163 */         reader.close();
/*     */       } 
/*     */       
/* 166 */       document.addCreationDate();
/*     */       
/* 168 */       if (info != null) {
/*     */         
/* 170 */         document.addAuthor(info.author());
/* 171 */         document.addCreator(info.creator());
/* 172 */         document.addTitle(info.title());
/* 173 */         document.addSubject(info.subject());
/* 174 */         document.addKeywords(info.keywords());
/*     */       } 
/*     */       
/* 177 */       copy.close();
/* 178 */       document.close();
/* 179 */       byteOS.close();
/*     */       
/* 181 */       return byteOS.toByteArray();
/*     */     }
/* 183 */     catch (Exception e) {
/* 184 */       return (byte[])Exceptions.throwIllegalStateException(e);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\pdf\PDFs.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */