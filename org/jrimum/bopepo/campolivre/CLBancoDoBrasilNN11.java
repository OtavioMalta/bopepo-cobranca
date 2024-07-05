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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CLBancoDoBrasilNN11
/*     */   extends AbstractCLBancoDoBrasil
/*     */ {
/*     */   private static final long serialVersionUID = -4859699102593834115L;
/* 105 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CLBancoDoBrasilNN11(Titulo titulo) {
/* 116 */     super(FIELDS_LENGTH);
/*     */     
/* 118 */     ContaBancaria conta = titulo.getContaBancaria();
/* 119 */     String nossoNumero = titulo.getNossoNumero();
/*     */     
/* 121 */     add((Field)new FixedField(nossoNumero, Integer.valueOf(11), (Filler)Fillers.ZERO_LEFT));
/*     */     
/* 123 */     add((Field)new FixedField(conta.getAgencia().getCodigo(), Integer.valueOf(4), (Filler)Fillers.ZERO_LEFT));
/* 124 */     add((Field)new FixedField(conta.getNumeroDaConta().getCodigoDaConta(), Integer.valueOf(8), (Filler)Fillers.ZERO_LEFT));
/*     */     
/* 126 */     add((Field)new FixedField(conta.getCarteira().getCodigo(), Integer.valueOf(2), (Filler)Fillers.ZERO_LEFT));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 132 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 138 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLBancoDoBrasilNN11.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */