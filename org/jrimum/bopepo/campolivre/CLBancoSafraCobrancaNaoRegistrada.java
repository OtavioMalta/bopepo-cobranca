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
/*     */ class CLBancoSafraCobrancaNaoRegistrada
/*     */   extends AbstractCLBancoSafra
/*     */ {
/*     */   private static final long serialVersionUID = -6573340701469029151L;
/* 105 */   protected static final Integer FIELDS_LENGTH = Integer.valueOf(5);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 110 */   private static final Integer CONTA_LENGTH = Integer.valueOf(5);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 115 */   private static final Integer CONTA_DIGITO_LENGTH = Integer.valueOf(1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 120 */   private static final Integer NOSSO_NUMERO_LENGTH = Integer.valueOf(17);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CLBancoSafraCobrancaNaoRegistrada() {
/* 130 */     super(FIELDS_LENGTH);
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
/* 141 */     checkNumeroDaContaNotNull(titulo);
/* 142 */     checkCodigoDoNumeroDaConta(titulo);
/* 143 */     checkCodigoDoNumeroDaContaMenorOuIgualQue(titulo, 999999);
/* 144 */     checkDigitoDoCodigoDoNumeroDaConta(titulo);
/* 145 */     checkNossoNumero(titulo);
/* 146 */     checkTamanhoDoNossoNumero(titulo, 17);
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
/* 157 */     add((Field)SISTEMA_CONSTANT_FIELD);
/* 158 */     add((Field)new FixedField(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), CONTA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 159 */     add((Field)new FixedField(titulo.getContaBancaria().getNumeroDaConta().getDigitoDaConta(), CONTA_DIGITO_LENGTH));
/* 160 */     add((Field)new FixedField(titulo.getNossoNumero(), NOSSO_NUMERO_LENGTH));
/* 161 */     add((Field)new FixedField(Integer.valueOf(AbstractCLBancoSafra.TipoDeCobranca.EXPRESS_BOLETO_EMITIDO_PELO_CLIENTE.codigo()), TIPO_COBRANCA_FIELD_LENGTH));
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLBancoSafraCobrancaNaoRegistrada.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */