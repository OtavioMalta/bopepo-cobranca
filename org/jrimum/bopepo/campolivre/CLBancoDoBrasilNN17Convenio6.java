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
/*     */ class CLBancoDoBrasilNN17Convenio6
/*     */   extends AbstractCLBancoDoBrasil
/*     */ {
/*     */   private static final long serialVersionUID = 3035422743112225831L;
/*     */   private static final int SERVICO = 21;
/* 104 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CLBancoDoBrasilNN17Convenio6(Titulo titulo) {
/* 114 */     super(FIELDS_LENGTH);
/*     */     
/* 116 */     ContaBancaria conta = titulo.getContaBancaria();
/* 117 */     String nossoNumero = titulo.getNossoNumero();
/*     */     
/* 119 */     add((Field)new FixedField(conta.getNumeroDaConta().getCodigoDaConta(), Integer.valueOf(6), (Filler)Fillers.ZERO_LEFT));
/*     */     
/* 121 */     add((Field)new FixedField(nossoNumero, Integer.valueOf(17), (Filler)Fillers.ZERO_LEFT));
/* 122 */     add((Field)new FixedField(Integer.valueOf(21), Integer.valueOf(2)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 129 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 135 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLBancoDoBrasilNN17Convenio6.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */