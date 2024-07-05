/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ import org.jrimum.texgit.type.Field;
/*     */ import org.jrimum.texgit.type.Filler;
/*     */ import org.jrimum.texgit.type.component.Fillers;
/*     */ import org.jrimum.texgit.type.component.FixedField;
/*     */ import org.jrimum.utilix.Exceptions;
/*     */ import org.jrimum.utilix.Objects;
/*     */ import org.jrimum.utilix.text.DateFormat;
/*     */ import org.jrimum.utilix.text.Strings;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CLUnibancoCobrancaRegistrada
/*     */   extends AbstractCLUnibanco
/*     */ {
/*     */   private static final long serialVersionUID = -2740172688796212239L;
/*  85 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(6);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String CODIGO_TRANSACAO = "04";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CLUnibancoCobrancaRegistrada(Titulo titulo) {
/*  97 */     super(FIELDS_LENGTH);
/*     */     
/*  99 */     ContaBancaria conta = titulo.getContaBancaria();
/*     */     
/* 101 */     Objects.checkNotNull(conta, "Conta Bancária NULA!");
/* 102 */     Objects.checkNotNull(titulo.getDataDoVencimento(), "Data de vencimento do título NULA!");
/* 103 */     Objects.checkNotNull(conta.getAgencia().getCodigo(), "Número da Agência Bancária NULO!");
/* 104 */     Objects.checkNotNull(conta.getAgencia().getDigitoVerificador(), "Dígito da Agência Bancária NULO!");
/* 105 */     Objects.checkNotNull(titulo.getNossoNumero(), "Nosso Número NULO!");
/*     */     
/* 107 */     add((Field)new FixedField("04", Integer.valueOf(2)));
/* 108 */     add((Field)new FixedField(titulo.getDataDoVencimento(), Integer.valueOf(6), DateFormat.YYMMDD.copy()));
/*     */     
/* 110 */     if (conta.getAgencia().getCodigo().intValue() > 0) {
/*     */       
/* 112 */       add((Field)new FixedField(conta.getAgencia().getCodigo(), Integer.valueOf(4), (Filler)Fillers.ZERO_LEFT));
/*     */     }
/*     */     else {
/*     */       
/* 116 */       throw new CampoLivreException(new IllegalArgumentException("Agência bancária com valor inválido, a agência deve ser um número inteiro positivo, e não: " + conta.getNumeroDaConta().getCodigoDaConta()));
/*     */     } 
/*     */ 
/*     */     
/* 120 */     if (StringUtils.isNumeric(conta.getAgencia().getDigitoVerificador())) {
/*     */       
/* 122 */       Integer digitoDaAgencia = Integer.valueOf(conta.getAgencia().getDigitoVerificador());
/*     */       
/* 124 */       if (digitoDaAgencia.intValue() >= 0) {
/*     */         
/* 126 */         add((Field)new FixedField(Integer.valueOf(digitoDaAgencia.intValue()), Integer.valueOf(1)));
/*     */       } else {
/*     */         
/* 129 */         throw new CampoLivreException(new IllegalArgumentException("O dígito da agência deve ser um número interio não-negativo, e não: [" + conta.getAgencia().getDigitoVerificador() + "]"));
/*     */       } 
/*     */     } else {
/*     */       
/* 133 */       throw new CampoLivreException(new IllegalArgumentException("O dígito da agência deve ser numérico, e não: [" + conta.getAgencia().getDigitoVerificador() + "]"));
/*     */     } 
/*     */     
/* 136 */     if (StringUtils.isNumeric(titulo.getNossoNumero())) {
/*     */       
/* 138 */       if (Long.valueOf(Strings.removeStartWithZeros(titulo.getNossoNumero())).longValue() > 0L) {
/*     */         
/* 140 */         add((Field)new FixedField(titulo.getNossoNumero(), Integer.valueOf(11), (Filler)Fillers.ZERO_LEFT));
/*     */       } else {
/*     */         
/* 143 */         throw new CampoLivreException(new IllegalArgumentException("O campo (nosso número) do título deve ser um número natural positivo, e não: [" + titulo.getNossoNumero() + "]"));
/*     */       } 
/*     */     } else {
/*     */       
/* 147 */       throw new CampoLivreException(new IllegalArgumentException("O campo (nosso número) do título deve ser numérico, e não: [" + titulo.getNossoNumero() + "]"));
/*     */     } 
/*     */     
/* 150 */     add((Field)new FixedField(calculeSuperDigito(titulo.getNossoNumero()), Integer.valueOf(1)));
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
/*     */   private String calculeSuperDigito(String nossoNumero) {
/* 178 */     return calculeDigitoEmModulo11("1" + nossoNumero);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 184 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 190 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLUnibancoCobrancaRegistrada.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */