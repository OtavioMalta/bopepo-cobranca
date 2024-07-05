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
/*     */ class CLBancoSafraCobrancaRegistrada
/*     */   extends AbstractCLBancoSafra
/*     */ {
/*     */   private static final long serialVersionUID = -4532989921797507161L;
/* 106 */   protected static final Integer FIELDS_LENGTH = Integer.valueOf(7);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   private static final Integer AGENCIA_LENGTH = Integer.valueOf(4);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 116 */   private static final Integer AGENCIA_DIGITO_LENGTH = Integer.valueOf(1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 121 */   private static final Integer CONTA_LENGTH = Integer.valueOf(8);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 126 */   private static final Integer CONTA_DIGITO_LENGTH = Integer.valueOf(1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 131 */   private static final Integer NOSSO_NUMERO_LENGTH = Integer.valueOf(9);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CLBancoSafraCobrancaRegistrada() {
/* 141 */     super(FIELDS_LENGTH);
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
/* 152 */     checkAgenciaNotNull(titulo);
/* 153 */     checkCodigoDaAgencia(titulo);
/* 154 */     checkCodigoDaAgenciaMenorOuIgualQue(titulo, 9999);
/* 155 */     checkDigitoDoCodigoDaAgencia(titulo);
/* 156 */     checkNumeroDaContaNotNull(titulo);
/* 157 */     checkCodigoDoNumeroDaConta(titulo);
/* 158 */     checkCodigoDoNumeroDaContaMenorOuIgualQue(titulo, 999999);
/* 159 */     checkDigitoDoCodigoDoNumeroDaConta(titulo);
/* 160 */     checkNossoNumero(titulo);
/* 161 */     checkTamanhoDoNossoNumero(titulo, 9);
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
/* 172 */     add((Field)SISTEMA_CONSTANT_FIELD);
/* 173 */     add((Field)new FixedField(titulo.getContaBancaria().getAgencia().getCodigo(), AGENCIA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 174 */     add((Field)new FixedField(titulo.getContaBancaria().getAgencia().getDigitoVerificador(), AGENCIA_DIGITO_LENGTH));
/* 175 */     add((Field)new FixedField(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), CONTA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 176 */     add((Field)new FixedField(titulo.getContaBancaria().getNumeroDaConta().getDigitoDaConta(), CONTA_DIGITO_LENGTH));
/* 177 */     add((Field)new FixedField(titulo.getNossoNumero(), NOSSO_NUMERO_LENGTH));
/* 178 */     add((Field)new FixedField(Integer.valueOf(AbstractCLBancoSafra.TipoDeCobranca.DIRETA_BOLETO_EMITIDO_PELO_CLIENTE.codigo()), TIPO_COBRANCA_FIELD_LENGTH));
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLBancoSafraCobrancaRegistrada.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */