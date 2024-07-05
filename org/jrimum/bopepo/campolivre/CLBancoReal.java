/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ import org.jrimum.texgit.type.Field;
/*     */ import org.jrimum.texgit.type.Filler;
/*     */ import org.jrimum.texgit.type.component.Fillers;
/*     */ import org.jrimum.texgit.type.component.FixedField;
/*     */ import org.jrimum.utilix.Exceptions;
/*     */ import org.jrimum.utilix.text.Strings;
/*     */ import org.jrimum.vallia.digitoverificador.Modulo;
/*     */ import org.jrimum.vallia.digitoverificador.TipoDeModulo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CLBancoReal
/*     */   extends AbstractCLBancoReal
/*     */ {
/*     */   private static final long serialVersionUID = -5294809022535972391L;
/* 100 */   private static final Modulo modulo10 = new Modulo(TipoDeModulo.MODULO10);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 105 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CLBancoReal(Titulo titulo) {
/* 115 */     super(FIELDS_LENGTH);
/*     */     
/* 117 */     add((Field)new FixedField(titulo.getContaBancaria().getAgencia().getCodigo(), Integer.valueOf(4), (Filler)Fillers.ZERO_LEFT));
/* 118 */     add((Field)new FixedField(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), Integer.valueOf(7), (Filler)Fillers.ZERO_LEFT));
/* 119 */     add((Field)new FixedField(calculeDigitoDaPosicao31(titulo.getNossoNumero(), titulo.getContaBancaria().getAgencia().getCodigo(), titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta()), Integer.valueOf(1), (Filler)Fillers.ZERO_LEFT));
/* 120 */     add((Field)new FixedField(Strings.eliminateSymbols(titulo.getNossoNumero()), Integer.valueOf(13), (Filler)Fillers.ZERO_LEFT));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String calculeDigitoDaPosicao31(String nossoNumero, Integer agencia, Integer contaCorrente) {
/* 162 */     StringBuilder formula = new StringBuilder();
/* 163 */     String dV = null;
/*     */     
/* 165 */     formula.append(Fillers.ZERO_LEFT.fill(nossoNumero, 13));
/* 166 */     formula.append(Fillers.ZERO_LEFT.fill(agencia, 4));
/* 167 */     formula.append(Fillers.ZERO_LEFT.fill(contaCorrente, 7));
/*     */     
/* 169 */     int restoDivisao = modulo10.calcule(formula.toString());
/*     */     
/* 171 */     int restoSubtracao = 10 - restoDivisao;
/*     */     
/* 173 */     if (restoSubtracao == 10) {
/* 174 */       dV = "0";
/*     */     } else {
/*     */       
/* 177 */       dV = "" + restoSubtracao;
/*     */     } 
/*     */     
/* 180 */     return dV;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 186 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 192 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLBancoReal.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */