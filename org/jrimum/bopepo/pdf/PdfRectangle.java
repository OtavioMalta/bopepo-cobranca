/*     */ package org.jrimum.bopepo.pdf;
/*     */ 
/*     */ import com.lowagie.text.Rectangle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PdfRectangle
/*     */   extends Rectangle
/*     */ {
/*     */   private int page;
/*     */   
/*     */   public PdfRectangle(float[] positions) {
/*  54 */     super(positions[1], positions[2], positions[3], positions[4]);
/*  55 */     this.page = (int)positions[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PdfRectangle(float llx, float lly, float urx, float ury) {
/*  65 */     super(llx, lly, urx, ury);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PdfRectangle(float urx, float ury) {
/*  75 */     super(urx, ury);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PdfRectangle(Rectangle rect) {
/*  83 */     super(rect);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPage() {
/*  90 */     return this.page;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getLowerLeftX() {
/*  97 */     return this.llx;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getLowerLeftY() {
/* 104 */     return this.lly;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getUpperRightX() {
/* 112 */     return this.urx;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getUpperRightY() {
/* 119 */     return this.ury;
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\pdf\PdfRectangle.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */