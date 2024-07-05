/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
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
/*     */ class CLBancoRuralCobrancaRegistrada
/*     */   extends AbstractCLBancoRural
/*     */ {
/*     */   private static final long serialVersionUID = -5166628254198207874L;
/*  86 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(7);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   private static final Integer TIPO_COBRANCA = Integer.valueOf(0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String ZEROS = "000";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CLBancoRuralCobrancaRegistrada(Titulo titulo) {
/* 109 */     super(FIELDS_LENGTH);
/*     */     
/* 111 */     add((Field)new FixedField(TIPO_COBRANCA, Integer.valueOf(1)));
/* 112 */     add((Field)new FixedField(titulo.getContaBancaria().getAgencia().getCodigo(), Integer.valueOf(3), (Filler)Fillers.ZERO_LEFT));
/* 113 */     add((Field)new FixedField(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), Integer.valueOf(9), (Filler)Fillers.ZERO_LEFT));
/* 114 */     add((Field)new FixedField(titulo.getContaBancaria().getNumeroDaConta().getDigitoDaConta(), Integer.valueOf(1)));
/* 115 */     add((Field)new FixedField(titulo.getNossoNumero(), Integer.valueOf(7), (Filler)Fillers.ZERO_LEFT));
/* 116 */     add((Field)new FixedField(titulo.getDigitoDoNossoNumero(), Integer.valueOf(1)));
/* 117 */     add((Field)new FixedField("000", Integer.valueOf(3)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 123 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 129 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLBancoRuralCobrancaRegistrada.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */