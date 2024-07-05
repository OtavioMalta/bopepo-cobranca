/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ import org.jrimum.texgit.type.Field;
/*     */ import org.jrimum.texgit.type.Filler;
/*     */ import org.jrimum.texgit.type.component.Fillers;
/*     */ import org.jrimum.texgit.type.component.FixedField;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CLCaixaEconomicaFederalSICOBNossoNumero14
/*     */   extends AbstractCLCaixaEconomicaFederal
/*     */ {
/*     */   private static final long serialVersionUID = 4219053358562778591L;
/* 117 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(5);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 122 */   private static final Integer CONTA_LENGTH = Integer.valueOf(5);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 127 */   private static final Integer AGENCIA_LENGTH = Integer.valueOf(4);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 132 */   protected static final Integer NOSSO_NUMERO_LENGTH = Integer.valueOf(14);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 137 */   private static final FixedField<Integer> CONSTANT_FIELD = new FixedField(Integer.valueOf(7), Integer.valueOf(1));
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 142 */   private static final Integer CARTEIRA_SEM_REGISTRO = Integer.valueOf(8);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 147 */   private static final FixedField<Integer> CARTEIRA_FIELD = new FixedField(CARTEIRA_SEM_REGISTRO, Integer.valueOf(1));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CLCaixaEconomicaFederalSICOBNossoNumero14() {
/* 158 */     super(FIELDS_LENGTH);
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
/* 169 */     checkNumeroDaContaNotNull(titulo);
/* 170 */     checkCodigoDoNumeroDaConta(titulo);
/* 171 */     checkCodigoDoNumeroDaContaMenorOuIgualQue(titulo, 99999);
/* 172 */     checkAgenciaNotNull(titulo);
/* 173 */     checkCodigoDaAgencia(titulo);
/* 174 */     checkCodigoDaAgenciaMenorOuIgualQue(titulo, 9999);
/* 175 */     checkCarteiraNotNull(titulo);
/* 176 */     checkCodigoDaCarteira(titulo);
/* 177 */     checkCodigoDaCarteiraMenorOuIgualQue(titulo, 9);
/* 178 */     checkCarteiraSemRegistro(titulo);
/* 179 */     checkNossoNumero(titulo);
/* 180 */     checkTamanhoDoNossoNumero(titulo, 14);
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
/* 191 */     add((Field)new FixedField(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), CONTA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 192 */     add((Field)new FixedField(titulo.getContaBancaria().getAgencia().getCodigo(), AGENCIA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 193 */     add((Field)CARTEIRA_FIELD);
/* 194 */     add((Field)CONSTANT_FIELD);
/* 195 */     add((Field)new FixedField(titulo.getNossoNumero(), NOSSO_NUMERO_LENGTH, (Filler)Fillers.ZERO_LEFT));
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
/*     */   private void checkCarteiraSemRegistro(Titulo titulo) {
/* 216 */     Objects.checkArgument(titulo.getContaBancaria().getCarteira().getCodigo().equals(CARTEIRA_SEM_REGISTRO), String.format("Apenas a carteira de código [8] \"Carteira Sem Registro Eletrônica\" é permitida e não o código [%s]!", new Object[] { titulo.getContaBancaria().getCarteira().getCodigo() }));
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLCaixaEconomicaFederalSICOBNossoNumero14.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */