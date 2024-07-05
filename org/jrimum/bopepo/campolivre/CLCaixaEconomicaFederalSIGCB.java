/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ import org.jrimum.texgit.type.Field;
/*     */ import org.jrimum.texgit.type.Filler;
/*     */ import org.jrimum.texgit.type.component.Fillers;
/*     */ import org.jrimum.texgit.type.component.FixedField;
/*     */ import org.jrimum.utilix.Exceptions;
/*     */ import org.jrimum.vallia.digitoverificador.Modulo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CLCaixaEconomicaFederalSIGCB
/*     */   extends AbstractCLCaixaEconomicaFederal
/*     */ {
/*     */   private static final long serialVersionUID = -7642075752245778160L;
/* 114 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(8);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int COBRANCA_REGISTRADA = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int COBRANCA_NAO_REGISTRADA = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int EMISSAO_CEDENTE = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CLCaixaEconomicaFederalSIGCB(Titulo titulo) {
/* 142 */     super(FIELDS_LENGTH);
/*     */     
/* 144 */     ContaBancaria conta = titulo.getContaBancaria();
/* 145 */     String nossoNumero = titulo.getNossoNumero();
/*     */     
/* 147 */     Integer dVCodigoDoCedente = Integer.valueOf(calculeDigitoVerificador(conta.getNumeroDaConta().getCodigoDaConta().toString()));
/*     */     
/* 149 */     add((Field)new FixedField(conta.getNumeroDaConta().getCodigoDaConta(), Integer.valueOf(6), (Filler)Fillers.ZERO_LEFT));
/* 150 */     add((Field)new FixedField(dVCodigoDoCedente, Integer.valueOf(1)));
/* 151 */     add((Field)new FixedField(nossoNumero.substring(0, 3), Integer.valueOf(3)));
/*     */     
/* 153 */     if (conta.getCarteira().isComRegistro()) {
/*     */       
/* 155 */       add((Field)new FixedField(Integer.valueOf(1), Integer.valueOf(1)));
/*     */     }
/*     */     else {
/*     */       
/* 159 */       add((Field)new FixedField(Integer.valueOf(2), Integer.valueOf(1)));
/*     */     } 
/*     */     
/* 162 */     add((Field)new FixedField(nossoNumero.substring(3, 6), Integer.valueOf(3)));
/* 163 */     add((Field)new FixedField(Integer.valueOf(4), Integer.valueOf(1)));
/* 164 */     add((Field)new FixedField(nossoNumero.substring(6, 15), Integer.valueOf(9)));
/*     */     
/* 166 */     add((Field)new FixedField(Integer.valueOf(calculeDigitoVerificador(gereCampoLivre())), Integer.valueOf(1)));
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
/*     */   private String gereCampoLivre() {
/* 191 */     return writeFields();
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
/*     */   private int calculeDigitoVerificador(String numeroParaCalculo) {
/* 204 */     int dvCampoLivre, soma = Modulo.calculeSomaSequencialMod11(numeroParaCalculo.toString(), 2, 9);
/*     */ 
/*     */ 
/*     */     
/* 208 */     if (soma < Modulo.MOD11) {
/*     */       
/* 210 */       dvCampoLivre = Modulo.MOD11 - soma;
/*     */     }
/*     */     else {
/*     */       
/* 214 */       int restoDiv11 = soma % Modulo.MOD11;
/*     */       
/* 216 */       int subResto = Modulo.MOD11 - restoDiv11;
/*     */       
/* 218 */       if (subResto > 9) {
/*     */         
/* 220 */         dvCampoLivre = 0;
/*     */       }
/*     */       else {
/*     */         
/* 224 */         dvCampoLivre = subResto;
/*     */       } 
/*     */     } 
/*     */     
/* 228 */     return dvCampoLivre;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 234 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 240 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLCaixaEconomicaFederalSIGCB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */