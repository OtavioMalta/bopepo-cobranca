/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
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
/*     */ class CLCaixaEconomicaFederalSINCO
/*     */   extends AbstractCLCaixaEconomicaFederal
/*     */ {
/*     */   private static final long serialVersionUID = -7642075752245778160L;
/*  91 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CLCaixaEconomicaFederalSINCO(Titulo titulo) {
/* 101 */     super(FIELDS_LENGTH);
/*     */     
/* 103 */     ContaBancaria conta = titulo.getContaBancaria();
/*     */     
/* 105 */     String nossoNumero = titulo.getNossoNumero();
/*     */     
/* 107 */     add((Field)new FixedField(Integer.valueOf(1), Integer.valueOf(1)));
/*     */     
/* 109 */     add((Field)new FixedField(conta.getNumeroDaConta().getCodigoDaConta(), Integer.valueOf(6), (Filler)Fillers.ZERO_LEFT));
/*     */     
/* 111 */     add((Field)new FixedField(Integer.valueOf(9), Integer.valueOf(1)));
/* 112 */     add((Field)new FixedField(nossoNumero, Integer.valueOf(17)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 118 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 124 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLCaixaEconomicaFederalSINCO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */