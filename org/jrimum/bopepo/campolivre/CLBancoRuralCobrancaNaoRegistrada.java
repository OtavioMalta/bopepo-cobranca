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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CLBancoRuralCobrancaNaoRegistrada
/*     */   extends AbstractCLBancoRural
/*     */ {
/*     */   private static final long serialVersionUID = -837754906530330855L;
/*  77 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(5);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  82 */   private static final Integer TIPO_COBRANCA = Integer.valueOf(9);
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
/*     */   CLBancoRuralCobrancaNaoRegistrada(Titulo titulo) {
/* 100 */     super(FIELDS_LENGTH);
/*     */     
/* 102 */     add((Field)new FixedField(TIPO_COBRANCA, Integer.valueOf(1)));
/* 103 */     add((Field)new FixedField(titulo.getContaBancaria().getAgencia().getCodigo(), Integer.valueOf(3), (Filler)Fillers.ZERO_LEFT));
/* 104 */     add((Field)new FixedField(titulo.getParametrosBancarios().getValor((ParametroBancario)ParametroBancoRural.CODIGO_REDUZIDO), Integer.valueOf(3), (Filler)Fillers.ZERO_LEFT));
/* 105 */     add((Field)new FixedField(titulo.getNossoNumero(), Integer.valueOf(15), (Filler)Fillers.ZERO_LEFT));
/* 106 */     add((Field)new FixedField("000", Integer.valueOf(3)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 112 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 118 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLBancoRuralCobrancaNaoRegistrada.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */