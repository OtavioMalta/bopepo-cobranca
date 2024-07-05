/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ import org.jrimum.texgit.type.Field;
/*     */ import org.jrimum.texgit.type.Filler;
/*     */ import org.jrimum.texgit.type.component.Fillers;
/*     */ import org.jrimum.texgit.type.component.FixedField;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CLMercantilDoBrasil
/*     */   extends AbstractCLMercantilDoBrasil
/*     */ {
/*     */   private static final long serialVersionUID = 2335934898236961987L;
/*  97 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CLMercantilDoBrasil(Titulo titulo) {
/* 106 */     super(FIELDS_LENGTH);
/*     */     int desconto;
/* 108 */     ContaBancaria contaBancaria = titulo.getContaBancaria();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     if (titulo.getDesconto() == null || titulo.getDesconto().equals(BigDecimal.ZERO.setScale(2, RoundingMode.DOWN))) {
/* 115 */       desconto = 2;
/*     */     } else {
/*     */       
/* 118 */       desconto = 0;
/*     */     } 
/*     */     
/* 121 */     add((Field)new FixedField(contaBancaria.getAgencia().getCodigo(), Integer.valueOf(4), (Filler)Fillers.ZERO_LEFT));
/*     */     
/* 123 */     add((Field)new FixedField(titulo.getNossoNumero() + titulo.getDigitoDoNossoNumero(), Integer.valueOf(11), (Filler)Fillers.ZERO_LEFT));
/*     */     
/* 125 */     add((Field)new FixedField(contaBancaria.getNumeroDaConta().getCodigoDaConta(), Integer.valueOf(9), (Filler)Fillers.ZERO_LEFT));
/*     */     
/* 127 */     add((Field)new FixedField(Integer.valueOf(desconto), Integer.valueOf(1)));
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
/*     */   protected void addFields(Titulo titulo) {
/* 158 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 164 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLMercantilDoBrasil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */