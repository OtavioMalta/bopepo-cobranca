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
/*     */ class CLBancoDoBrasilNN10
/*     */   extends AbstractCLBancoDoBrasil
/*     */ {
/*     */   private static final long serialVersionUID = -7675528811239346517L;
/* 104 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CLBancoDoBrasilNN10(Titulo titulo) {
/* 114 */     super(FIELDS_LENGTH);
/*     */     
/* 116 */     ContaBancaria conta = titulo.getContaBancaria();
/*     */     
/* 118 */     String nossoNumero = titulo.getNossoNumero();
/*     */     
/* 120 */     add((Field)new FixedField("", Integer.valueOf(6), (Filler)Fillers.ZERO_LEFT));
/*     */     
/* 122 */     add((Field)new FixedField(conta.getNumeroDaConta().getCodigoDaConta(), Integer.valueOf(7), (Filler)Fillers.ZERO_LEFT));
/*     */     
/* 124 */     add((Field)new FixedField(nossoNumero, Integer.valueOf(10), (Filler)Fillers.ZERO_LEFT));
/*     */     
/* 126 */     add((Field)new FixedField(conta.getCarteira().getCodigo(), Integer.valueOf(2), (Filler)Fillers.ZERO_LEFT));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 133 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 139 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLBancoDoBrasilNN10.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */