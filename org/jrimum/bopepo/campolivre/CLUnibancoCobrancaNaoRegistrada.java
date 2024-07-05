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
/*     */ class CLUnibancoCobrancaNaoRegistrada
/*     */   extends AbstractCLUnibanco
/*     */ {
/*     */   private static final long serialVersionUID = 487906631678160993L;
/*  79 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(6);
/*     */   
/*  81 */   private static final Integer CODIGO_TRANSACAO = Integer.valueOf(5);
/*     */   
/*  83 */   private static final Integer RESERVADO = Integer.valueOf(0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CLUnibancoCobrancaNaoRegistrada(Titulo titulo) {
/*  93 */     super(FIELDS_LENGTH);
/*     */     
/*  95 */     ContaBancaria conta = titulo.getContaBancaria();
/*     */     
/*  97 */     Objects.checkNotNull(conta, "Conta Bancária NULA!");
/*  98 */     Objects.checkNotNull(conta.getNumeroDaConta(), "Número da Conta Bancária NULO!");
/*  99 */     Objects.checkNotNull(conta.getNumeroDaConta().getCodigoDaConta(), "Código da Conta Bancária NULO!");
/* 100 */     Objects.checkNotNull(conta.getNumeroDaConta().getDigitoDaConta(), "Dígito da Conta Bancária NULO!");
/* 101 */     Objects.checkNotNull(titulo.getNossoNumero(), "Nosso Número NULO!");
/*     */     
/* 103 */     add((Field)new FixedField(CODIGO_TRANSACAO, Integer.valueOf(1)));
/*     */     
/* 105 */     if (conta.getNumeroDaConta().getCodigoDaConta().intValue() > 0) {
/*     */       
/* 107 */       add((Field)new FixedField(conta.getNumeroDaConta().getCodigoDaConta(), Integer.valueOf(6), (Filler)Fillers.ZERO_LEFT));
/*     */     } else {
/*     */       
/* 110 */       throw new CampoLivreException(new IllegalArgumentException("Conta bancária com valor inválido, a conta deve ser um número inteiro positivo, e não: " + conta.getNumeroDaConta().getCodigoDaConta()));
/*     */     } 
/*     */     
/* 113 */     if (StringUtils.isNumeric(conta.getNumeroDaConta().getDigitoDaConta())) {
/*     */       
/* 115 */       Integer digitoDaConta = Integer.valueOf(conta.getNumeroDaConta().getDigitoDaConta());
/*     */       
/* 117 */       if (digitoDaConta.intValue() >= 0) {
/*     */         
/* 119 */         add((Field)new FixedField(Integer.valueOf(digitoDaConta.intValue()), Integer.valueOf(1)));
/*     */       } else {
/*     */         
/* 122 */         throw new CampoLivreException(new IllegalArgumentException("O dígito da conta deve ser um número inteiro não-negativo, e não: [" + conta.getNumeroDaConta().getDigitoDaConta() + "]"));
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 127 */       throw new CampoLivreException(new IllegalArgumentException("O dígito da conta deve ser numérico, e não: [" + conta.getNumeroDaConta().getDigitoDaConta() + "]"));
/*     */     } 
/*     */     
/* 130 */     add((Field)new FixedField(RESERVADO, Integer.valueOf(2), (Filler)Fillers.ZERO_LEFT));
/*     */     
/* 132 */     if (StringUtils.isNumeric(titulo.getNossoNumero())) {
/*     */       
/* 134 */       if (Long.valueOf(Strings.removeStartWithZeros(titulo.getNossoNumero())).longValue() > 0L) {
/*     */         
/* 136 */         add((Field)new FixedField(titulo.getNossoNumero(), Integer.valueOf(14), (Filler)Fillers.ZERO_LEFT));
/*     */       }
/*     */       else {
/*     */         
/* 140 */         throw new CampoLivreException(new IllegalArgumentException("O campo (nosso número) do título deve ser um número inteiro positivo, e não: [" + titulo.getNossoNumero() + "]"));
/*     */       } 
/*     */     } else {
/*     */       
/* 144 */       throw new CampoLivreException(new IllegalArgumentException("O campo (nosso número) do título deve ser numérico, e não: [" + titulo.getNossoNumero() + "]"));
/*     */     } 
/*     */     
/* 147 */     add((Field)new FixedField(calculeDigitoEmModulo11(titulo.getNossoNumero()), Integer.valueOf(1)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 153 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 159 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLUnibancoCobrancaNaoRegistrada.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */