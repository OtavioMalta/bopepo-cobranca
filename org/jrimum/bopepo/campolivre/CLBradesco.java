/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ import org.jrimum.texgit.type.Field;
/*     */ import org.jrimum.texgit.type.Filler;
/*     */ import org.jrimum.texgit.type.component.Fillers;
/*     */ import org.jrimum.texgit.type.component.FixedField;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CLBradesco
/*     */   extends AbstractCLBradesco
/*     */ {
/*     */   private static final long serialVersionUID = -1253549781074159862L;
/* 113 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(5);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 118 */   private static final Integer AGENCIA_LENGTH = Integer.valueOf(4);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 123 */   private static final Integer CARTEIRA_LENGTH = Integer.valueOf(2);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 128 */   private static final Integer NOSSO_NUMERO_LENGTH = Integer.valueOf(11);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 133 */   private static final Integer CONTA_LENGTH = Integer.valueOf(7);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 138 */   private static final Integer CONSTANT_LENGTH = Integer.valueOf(1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 143 */   private static final Integer CONSTANT_VALUE = Integer.valueOf(0);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 148 */   private static final FixedField<Integer> CONSTANT_FIELD = new FixedField(CONSTANT_VALUE, CONSTANT_LENGTH);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CLBradesco() {
/* 157 */     super(FIELDS_LENGTH);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 168 */     checkAgenciaNotNull(titulo);
/* 169 */     checkCodigoDaAgencia(titulo);
/* 170 */     checkCodigoDaAgenciaMenorOuIgualQue(titulo, 9999);
/* 171 */     checkCarteiraNotNull(titulo);
/* 172 */     checkCodigoDaCarteira(titulo);
/* 173 */     checkCodigoDaCarteiraMenorOuIgualQue(titulo, 99);
/* 174 */     checkNossoNumero(titulo);
/* 175 */     checkTamanhoDoNossoNumero(titulo, 11);
/* 176 */     checkNumeroDaContaNotNull(titulo);
/* 177 */     checkCodigoDoNumeroDaConta(titulo);
/* 178 */     checkCodigoDoNumeroDaContaMenorOuIgualQue(titulo, 9999999);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 189 */     add((Field)new FixedField(titulo.getContaBancaria().getAgencia().getCodigo(), AGENCIA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 190 */     add((Field)new FixedField(titulo.getContaBancaria().getCarteira().getCodigo(), CARTEIRA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 191 */     add((Field)new FixedField(titulo.getNossoNumero(), NOSSO_NUMERO_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 192 */     add((Field)new FixedField(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), CONTA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 193 */     add((Field)CONSTANT_FIELD);
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLBradesco.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */