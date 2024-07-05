/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import org.jrimum.bopepo.parametro.ParametroBancoSantander;
/*     */ import org.jrimum.domkee.financeiro.banco.ParametroBancario;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ import org.jrimum.texgit.type.Field;
/*     */ import org.jrimum.texgit.type.Filler;
/*     */ import org.jrimum.texgit.type.component.Fillers;
/*     */ import org.jrimum.texgit.type.component.FixedField;
/*     */ import org.jrimum.utilix.Exceptions;
/*     */ import org.jrimum.utilix.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CLBancoSantander
/*     */   extends AbstractCLSantander
/*     */   implements CampoLivre
/*     */ {
/*     */   private static final long serialVersionUID = -412221524249334574L;
/*  97 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(6);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 102 */   private static final Integer CONSTANTE = Integer.valueOf(9);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int CARTEIRA_RAPIDA_COM_REGISTRO = 101;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int CARTEIRA_RAPIDA_SEM_REGISTRO = 201;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int CARTEIRA_SIMPLES_SEM_REGISTRO = 102;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int COBRANCA_SIMPLES_ELETRONICA_COM_REGISTRO = 104;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CLBancoSantander(Titulo titulo) {
/* 125 */     super(FIELDS_LENGTH);
/*     */     
/* 127 */     ContaBancaria conta = titulo.getContaBancaria();
/* 128 */     StringBuilder nossoNumero = new StringBuilder(titulo.getNossoNumero());
/* 129 */     nossoNumero.append(titulo.getDigitoDoNossoNumero());
/*     */     
/* 131 */     add((Field)new FixedField(CONSTANTE, Integer.valueOf(1)));
/* 132 */     add((Field)new FixedField(conta.getNumeroDaConta().getCodigoDaConta(), Integer.valueOf(6), (Filler)Fillers.ZERO_LEFT));
/* 133 */     add((Field)new FixedField(conta.getNumeroDaConta().getDigitoDaConta(), Integer.valueOf(1)));
/*     */     
/* 135 */     add((Field)new FixedField(nossoNumero.toString(), Integer.valueOf(13), (Filler)Fillers.ZERO_LEFT));
/*     */ 
/*     */ 
/*     */     
/* 139 */     if (titulo.hasParametrosBancarios() && Objects.isNotNull(titulo.getParametrosBancarios().getValor((ParametroBancario)ParametroBancoSantander.IOF_SEGURADORA))) {
/*     */ 
/*     */ 
/*     */       
/* 143 */       add((Field)new FixedField(titulo.getParametrosBancarios().getValor((ParametroBancario)ParametroBancoSantander.IOF_SEGURADORA), Integer.valueOf(1)));
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 148 */       add((Field)new FixedField(Integer.valueOf(0), Integer.valueOf(1)));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 153 */     switch (conta.getCarteira().getCodigo().intValue()) {
/*     */ 
/*     */       
/*     */       case 101:
/*     */       case 102:
/*     */       case 104:
/*     */       case 201:
/* 160 */         add((Field)new FixedField(conta.getCarteira().getCodigo(), Integer.valueOf(3), (Filler)Fillers.ZERO_LEFT));
/*     */         return;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 167 */     Exceptions.throwIllegalArgumentException(String.format("CARTEIRA [%s] NÃO SUPORTADA!", new Object[] { conta.getCarteira().getCodigo() }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 176 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 182 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLBancoSantander.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */