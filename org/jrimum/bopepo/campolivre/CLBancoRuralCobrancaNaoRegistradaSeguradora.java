/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import org.jrimum.bopepo.parametro.ParametroBancoRural;
/*     */ import org.jrimum.domkee.financeiro.banco.ParametroBancario;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ import org.jrimum.texgit.type.Field;
/*     */ import org.jrimum.texgit.type.Filler;
/*     */ import org.jrimum.texgit.type.component.Fillers;
/*     */ import org.jrimum.texgit.type.component.FixedField;
/*     */ import org.jrimum.utilix.Exceptions;
/*     */ import org.jrimum.utilix.text.DecimalFormat;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CLBancoRuralCobrancaNaoRegistradaSeguradora
/*     */   extends AbstractCLBancoRural
/*     */ {
/*     */   private static final long serialVersionUID = -2427800425370567806L;
/*  89 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(6);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  94 */   private static final Integer TIPO_COBRANCA = Integer.valueOf(4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CLBancoRuralCobrancaNaoRegistradaSeguradora(Titulo titulo) {
/* 106 */     super(FIELDS_LENGTH);
/*     */     
/* 108 */     add((Field)new FixedField(TIPO_COBRANCA, Integer.valueOf(1)));
/* 109 */     add((Field)new FixedField(titulo.getContaBancaria().getAgencia().getCodigo(), Integer.valueOf(3), (Filler)Fillers.ZERO_LEFT));
/* 110 */     add((Field)new FixedField(titulo.getParametrosBancarios().getValor((ParametroBancario)ParametroBancoRural.CODIGO_REDUZIDO), Integer.valueOf(3), (Filler)Fillers.ZERO_LEFT));
/* 111 */     add((Field)new FixedField(titulo.getNossoNumero(), Integer.valueOf(10), (Filler)Fillers.ZERO_LEFT));
/* 112 */     add((Field)new FixedField(titulo.getDigitoDoNossoNumero(), Integer.valueOf(1), (Filler)Fillers.ZERO_LEFT));
/* 113 */     add((Field)new FixedField(titulo.getParametrosBancarios().getValor((ParametroBancario)ParametroBancoRural.VALOR_IOS), Integer.valueOf(7), DecimalFormat.NUMBER_DD_BR.copy(), (Filler)Fillers.ZERO_LEFT));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 119 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 125 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLBancoRuralCobrancaNaoRegistradaSeguradora.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */