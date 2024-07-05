/*     */ package org.jrimum.bopepo.pdf;
/*     */ 
/*     */ import com.lowagie.text.pdf.BarcodeInter25;
/*     */ import java.awt.Color;
/*     */ import java.awt.Image;
/*     */ import org.jrimum.utilix.Exceptions;
/*     */ import org.jrimum.utilix.Objects;
/*     */ import org.jrimum.utilix.text.Strings;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CodigoDeBarras
/*     */ {
/*     */   private String codigo;
/*     */   
/*     */   private CodigoDeBarras() {
/*  69 */     Exceptions.throwIllegalStateException("Instanciação não permitida!");
/*     */   }
/*     */ 
/*     */   
/*     */   public CodigoDeBarras(String codigo) {
/*  74 */     checkCodigo(codigo);
/*     */     
/*  76 */     this.codigo = codigo;
/*     */   }
/*     */   
/*     */   public static CodigoDeBarras valueOf(String codigo) {
/*  80 */     checkCodigo(codigo);
/*  81 */     return new CodigoDeBarras(codigo);
/*     */   }
/*     */ 
/*     */   
/*     */   public String write() {
/*  86 */     return this.codigo;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Image toImage() {
/*  92 */     BarcodeInter25 barCode = new BarcodeInter25();
/*  93 */     barCode.setCode(write());
/*     */     
/*  95 */     barCode.setExtended(true);
/*  96 */     barCode.setBarHeight(35.0F);
/*  97 */     barCode.setFont(null);
/*  98 */     barCode.setN(3.0F);
/*     */     
/* 100 */     return barCode.createAwtImage(Color.BLACK, Color.WHITE);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void checkCodigo(String str) {
/* 105 */     Objects.checkNotNull(str, "Código nulo!");
/* 106 */     Strings.checkNotBlank(str, String.format("Código ausente! str = \"%s\"", new Object[] { str }));
/* 107 */     Strings.checkNotNumeric(str, String.format("Código não contém apenas números! str = \"%s\"", new Object[] { str }));
/* 108 */     Objects.checkArgument((str.length() == 44), String.format("Código com tamanho diferente de 44 dígitos! str = \"%s\"", new Object[] { str }));
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\pdf\CodigoDeBarras.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */