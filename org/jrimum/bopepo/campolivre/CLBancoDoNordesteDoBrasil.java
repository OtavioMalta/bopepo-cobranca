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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CLBancoDoNordesteDoBrasil
/*     */   extends AbstractCLBancoDoNordesteDoBrasil
/*     */ {
/*     */   private static final long serialVersionUID = 5203223333877548162L;
/* 125 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(7);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 130 */   private static final Integer AGENCIA_LENGTH = Integer.valueOf(4);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 135 */   private static final Integer CONTA_LENGTH = Integer.valueOf(7);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 140 */   private static final Integer DIGITO_CONTA_LENGTH = Integer.valueOf(1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 146 */   private static final Integer NOSSO_NUMERO_LENGTH = Integer.valueOf(7);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 151 */   private static final Integer DIGITO_NOSSO_NUMERO_LENGTH = Integer.valueOf(1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 156 */   private static final Integer CARTEIRA_LENGTH = Integer.valueOf(2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 162 */   private static final Integer CAMPO_ZERADO_LENGTH = Integer.valueOf(3);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 167 */   protected static final Integer CAMPO_ZERADO_VALUE = Integer.valueOf(0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CLBancoDoNordesteDoBrasil() {
/* 177 */     super(FIELDS_LENGTH);
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
/* 188 */     checkAgenciaNotNull(titulo);
/* 189 */     checkCodigoDaAgencia(titulo);
/* 190 */     checkCodigoDaAgenciaMenorOuIgualQue(titulo, 9999);
/* 191 */     checkNumeroDaContaNotNull(titulo);
/* 192 */     checkCodigoDoNumeroDaConta(titulo);
/* 193 */     checkCodigoDoNumeroDaContaMenorOuIgualQue(titulo, 9999999);
/* 194 */     checkDigitoDoCodigoDoNumeroDaConta(titulo);
/* 195 */     checkNossoNumero(titulo);
/* 196 */     checkDigitoDoNossoNumero(titulo);
/* 197 */     checkCarteiraNotNull(titulo);
/* 198 */     checkCodigoDaCarteira(titulo);
/* 199 */     checkCodigoDaCarteiraMenorOuIgualQue(titulo, 99);
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
/* 210 */     add((Field)new FixedField(titulo.getContaBancaria().getAgencia().getCodigo(), AGENCIA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 211 */     add((Field)new FixedField(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), CONTA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 212 */     add((Field)new FixedField(titulo.getContaBancaria().getNumeroDaConta().getDigitoDaConta(), DIGITO_CONTA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 213 */     add((Field)new FixedField(titulo.getNossoNumero(), NOSSO_NUMERO_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 214 */     add((Field)new FixedField(titulo.getDigitoDoNossoNumero(), DIGITO_NOSSO_NUMERO_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 215 */     add((Field)new FixedField(titulo.getContaBancaria().getCarteira().getCodigo(), CARTEIRA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 216 */     add((Field)new FixedField(CAMPO_ZERADO_VALUE, CAMPO_ZERADO_LENGTH, (Filler)Fillers.ZERO_LEFT));
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLBancoDoNordesteDoBrasil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */