/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import org.jrimum.bopepo.parametro.ParametroHSBC;
/*     */ import org.jrimum.domkee.financeiro.banco.ParametroBancario;
/*     */ import org.jrimum.domkee.financeiro.banco.ParametrosBancariosMap;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CLHSBCCobrancaNaoRegistrada
/*     */   extends AbstractCLHSBC
/*     */ {
/*     */   private static final long serialVersionUID = -1253549781074159862L;
/* 120 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   CLHSBCCobrancaNaoRegistrada(Titulo titulo) {
/* 133 */     super(FIELDS_LENGTH);
/*     */     
/* 135 */     checkExistsParametrosBancarios(titulo);
/* 136 */     checkExistsParametroTipoIdentificadorCNR(titulo.getParametrosBancarios());
/*     */ 
/*     */     
/* 139 */     Integer tipoIdentificadorCNR = (Integer)titulo.getParametrosBancarios().getValor((ParametroBancario)ParametroHSBC.IDENTIFICADOR_CNR);
/*     */ 
/*     */     
/* 142 */     ContaBancaria conta = titulo.getContaBancaria();
/* 143 */     String nossoNumero = titulo.getNossoNumero();
/*     */ 
/*     */     
/* 146 */     add((Field)new FixedField(conta.getNumeroDaConta().getCodigoDaConta(), Integer.valueOf(7), (Filler)Fillers.ZERO_LEFT));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 151 */     add((Field)new FixedField(nossoNumero, Integer.valueOf(13), (Filler)Fillers.ZERO_LEFT));
/*     */     
/* 153 */     add((Field)new FixedField(getDataVencimentoFormatoJuliano(tipoIdentificadorCNR, titulo.getDataDoVencimento()), Integer.valueOf(4), (Filler)Fillers.ZERO_LEFT));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 158 */     add((Field)new FixedField(Integer.valueOf(2), Integer.valueOf(1)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String getDataVencimentoFormatoJuliano(Integer tipoIdentificadorCNR, Date vencimento) {
/* 164 */     int SEM_VENCIMENTO = 5;
/* 165 */     int COM_VENCIMENTO = 4;
/*     */     
/* 167 */     switch (tipoIdentificadorCNR.intValue()) {
/*     */ 
/*     */       
/*     */       case 5:
/* 171 */         return "0000";
/*     */ 
/*     */       
/*     */       case 4:
/* 175 */         return getVencimentoFormatoJuliano(vencimento);
/*     */     } 
/*     */     
/* 178 */     return (String)Exceptions.throwIllegalStateException("Tipo de identificador CNR desconhecido!");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String getVencimentoFormatoJuliano(Date vencimento) {
/* 184 */     Calendar c = Calendar.getInstance();
/* 185 */     c.setTime(vencimento);
/*     */     
/* 187 */     return String.valueOf(c.get(6)) + String.valueOf(c.get(1) % 10);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkExistsParametrosBancarios(Titulo titulo) {
/* 194 */     if (Objects.isNull(titulo.getParametrosBancarios()) && titulo.getParametrosBancarios().isVazio())
/*     */     {
/*     */       
/* 197 */       throw new CampoLivreException("Parâmetros bancários nulos em \"Titulo.parametrosBancarios\". O parâmetro bancário de nome e tipo [ IDENTIFICADOR_CNR ] deve ser fornecido para este caso.");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkExistsParametroTipoIdentificadorCNR(ParametrosBancariosMap parametros) {
/* 205 */     Integer tipoIdentificadorCNR = (Integer)parametros.getValor((ParametroBancario)ParametroHSBC.IDENTIFICADOR_CNR);
/*     */ 
/*     */     
/* 208 */     if (Objects.isNull(tipoIdentificadorCNR))
/*     */     {
/* 210 */       throw new CampoLivreException("Parâmetro bancário [ IDENTIFICADOR_CNR ] não encontrado em \"Titulo.parametrosBancarios\". O nome do parâmetro deve ser IDENTIFICADOR_CNR.");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 218 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 224 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLHSBCCobrancaNaoRegistrada.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */