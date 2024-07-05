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
/*     */ class CLBancoDoBrasilNN17Convenio7
/*     */   extends AbstractCLBancoDoBrasil
/*     */ {
/*     */   private static final long serialVersionUID = 2347714390743602306L;
/*  64 */   protected static final Integer FIELDS_LENGTH = Integer.valueOf(3);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   protected static final Integer CONSTANT_LENGTH = Integer.valueOf(6);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  74 */   protected static final Integer CONSTANT_VALUE = Integer.valueOf(0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  80 */   private static final FixedField<Integer> CONSTANT_FIELD = new FixedField(CONSTANT_VALUE, CONSTANT_LENGTH, (Filler)Fillers.ZERO_LEFT);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  85 */   protected static final Integer NOSSO_NUMERO_LENGTH = Integer.valueOf(17);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   protected static final Integer CARTEIRA_LENGTH = Integer.valueOf(2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CLBancoDoBrasilNN17Convenio7() {
/* 102 */     super(FIELDS_LENGTH);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 108 */     checkNossoNumero(titulo);
/* 109 */     checkTamanhoDoNossoNumero(titulo, 17);
/* 110 */     checkCarteiraNotNull(titulo);
/* 111 */     checkCodigoDaCarteira(titulo);
/* 112 */     checkCodigoDaCarteiraMenorOuIgualQue(titulo, 99);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 118 */     add((Field)CONSTANT_FIELD);
/* 119 */     add((Field)new FixedField(titulo.getNossoNumero(), NOSSO_NUMERO_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 120 */     add((Field)new FixedField(titulo.getContaBancaria().getCarteira().getCodigo(), CARTEIRA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLBancoDoBrasilNN17Convenio7.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */