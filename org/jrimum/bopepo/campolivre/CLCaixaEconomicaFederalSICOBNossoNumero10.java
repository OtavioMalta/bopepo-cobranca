/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import org.jrimum.bopepo.parametro.ParametroCaixaEconomicaFederal;
/*     */ import org.jrimum.domkee.financeiro.banco.ParametroBancario;
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
/*     */ class CLCaixaEconomicaFederalSICOBNossoNumero10
/*     */   extends AbstractCLCaixaEconomicaFederal
/*     */ {
/*     */   private static final long serialVersionUID = 5585190685525441426L;
/*  90 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CLCaixaEconomicaFederalSICOBNossoNumero10(Titulo titulo) {
/* 102 */     super(FIELDS_LENGTH);
/*     */     
/* 104 */     Objects.checkNotNull(titulo.getParametrosBancarios(), "Parâmetros bancários necessários [titulo.getParametrosBancarios()==null]!");
/* 105 */     checkPadraoNossoNumero(titulo.getNossoNumero());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     add((Field)new FixedField(titulo.getNossoNumero(), Integer.valueOf(10)));
/*     */     
/* 117 */     add((Field)new FixedField(titulo.getContaBancaria().getAgencia().getCodigo(), Integer.valueOf(4), (Filler)Fillers.ZERO_LEFT));
/*     */     
/* 119 */     if (titulo.getParametrosBancarios().contemComNome((ParametroBancario)ParametroCaixaEconomicaFederal.CODIGO_OPERACAO)) {
/*     */       
/* 121 */       Integer cnpv = (Integer)titulo.getParametrosBancarios().getValor((ParametroBancario)ParametroCaixaEconomicaFederal.CODIGO_OPERACAO);
/*     */       
/* 123 */       Objects.checkNotNull(titulo.getParametrosBancarios(), "Parâmetro bancário código operação inválido [CodigoOperacao==null]!");
/*     */       
/* 125 */       add((Field)new FixedField(cnpv, Integer.valueOf(3), (Filler)Fillers.ZERO_LEFT));
/*     */       
/* 127 */       add((Field)new FixedField(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), Integer.valueOf(8), (Filler)Fillers.ZERO_LEFT));
/*     */     }
/*     */     else {
/*     */       
/* 131 */       throw new CampoLivreException("Parâmetro bancário código operação (\"CodigoOperacao\") não encontrado!");
/*     */     } 
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
/*     */   private void checkPadraoNossoNumero(String nn) {
/* 159 */     if (!nn.startsWith("3") && !nn.startsWith("9") && !nn.startsWith("80") && !nn.startsWith("81") && !nn.startsWith("82")) {
/* 160 */       Exceptions.throwIllegalArgumentException(String.format("Para a cobrança SICOB o nosso número [%s] deve começar com 3 que é o identificador da \"carteira siples\" [3NNNNNNNNN] ou 9 que é o identificador da \"carteira rápida\" [9NNNNNNNNN] ou 80, 81 e 82 para \"carteira sem registro\" [82NNNNNNNN]!", new Object[] { nn }));
/*     */     }
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
/*     */   private void checkPadraoNossoNumeroPorCodigoDaCarteira(String nossoNumero, Integer codigoDaCarteira) {
/* 184 */     switch (codigoDaCarteira.intValue()) {
/*     */       case 11:
/* 186 */         if (!nossoNumero.startsWith("3")) {
/* 187 */           Exceptions.throwIllegalArgumentException(String.format("Para a cobrança SICOB, carteira 11 (cobrança simples), o nosso número [%s] deve começar com 3!", new Object[] { nossoNumero }));
/*     */         }
/*     */         break;
/*     */       
/*     */       case 12:
/* 192 */         if (!nossoNumero.startsWith("9")) {
/* 193 */           Exceptions.throwIllegalArgumentException(String.format("Para a cobrança SICOB, carteira 12 (cobrança rápida), o nosso número [%s] deve começar com 9!", new Object[] { nossoNumero }));
/*     */         }
/*     */         break;
/*     */       
/*     */       case 14:
/* 198 */         if (!nossoNumero.startsWith("80") && !nossoNumero.startsWith("81") && !nossoNumero.startsWith("82")) {
/* 199 */           Exceptions.throwIllegalArgumentException(String.format("Para a cobrança SICOB, carteira 14 (cobrança sem registro), o nosso número [%s] deve começar com 80, 81 ou 82!", new Object[] { nossoNumero }));
/*     */         }
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 209 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 215 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLCaixaEconomicaFederalSICOBNossoNumero10.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */