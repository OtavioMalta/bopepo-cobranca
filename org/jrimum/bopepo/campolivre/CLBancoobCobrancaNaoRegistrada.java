/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import org.jrimum.bopepo.parametro.ParametroBancoob;
/*     */ import org.jrimum.domkee.financeiro.banco.ParametroBancario;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CLBancoobCobrancaNaoRegistrada
/*     */   extends AbstractCLBancoob
/*     */ {
/*     */   private static final long serialVersionUID = 2864939240695151533L;
/* 127 */   protected static final Integer FIELDS_LENGTH = Integer.valueOf(8);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 132 */   protected static final Integer CARTEIRA_LENGTH = Integer.valueOf(1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 137 */   protected static final Integer AGENCIA_LENGTH = Integer.valueOf(4);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 142 */   protected static final Integer MODALIDADE_DE_COBRANCA_LENGTH = Integer.valueOf(2);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 147 */   protected static final Integer COBRANCA_SIMPLES = Integer.valueOf(1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 152 */   private static final Integer NOSSO_NUMERO_LENGTH = Integer.valueOf(7);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 157 */   private static final Integer DV_NOSSO_NUMERO_LENGTH = Integer.valueOf(1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 162 */   private static final Integer CONTA_LENGTH = Integer.valueOf(6);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 167 */   private static final Integer DV_CONTA_LENGTH = Integer.valueOf(1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 172 */   private static final Integer UMA_PARCELA = Integer.valueOf(1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 177 */   private static final Integer NUMERO_DA_PARCELA_LENGTH = Integer.valueOf(3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CLBancoobCobrancaNaoRegistrada() {
/* 187 */     super(FIELDS_LENGTH);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 193 */     checkCarteiraNotNull(titulo);
/* 194 */     checkCodigoDaCarteira(titulo);
/* 195 */     checkCodigoDaCarteiraMenorOuIgualQue(titulo, 9);
/* 196 */     checkAgenciaNotNull(titulo);
/* 197 */     checkCodigoDaAgencia(titulo);
/* 198 */     checkCodigoDaAgenciaMenorOuIgualQue(titulo, 9999);
/* 199 */     checkNossoNumero(titulo);
/* 200 */     checkTamanhoDoNossoNumero(titulo, 7);
/* 201 */     checkDigitoDoNossoNumero(titulo);
/* 202 */     checkTamanhoDigitoDoNossoNumero(titulo, DV_NOSSO_NUMERO_LENGTH.intValue());
/* 203 */     checkNumeroDaContaNotNull(titulo);
/* 204 */     checkCodigoDoNumeroDaConta(titulo);
/* 205 */     checkCodigoDoNumeroDaContaMenorOuIgualQue(titulo, 9999999);
/* 206 */     checkDigitoDoCodigoDoNumeroDaConta(titulo);
/* 207 */     checkCodigoDoNumeroDaContaMenorOuIgualQue(titulo, 999999);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 213 */     Integer codigoDaModalidadeDeCobranca = COBRANCA_SIMPLES;
/* 214 */     Integer numeroDaParcela = UMA_PARCELA;
/*     */     
/* 216 */     if (titulo.hasParametrosBancarios()) {
/*     */       
/* 218 */       if (titulo.getParametrosBancarios().contemComNome((ParametroBancario)ParametroBancoob.MODALIDADE_DE_COBRANCA)) {
/* 219 */         checkParametroBancario(titulo, (ParametroBancario<?>)ParametroBancoob.MODALIDADE_DE_COBRANCA);
/* 220 */         codigoDaModalidadeDeCobranca = (Integer)titulo.getParametrosBancarios().getValor((ParametroBancario)ParametroBancoob.MODALIDADE_DE_COBRANCA);
/*     */       } 
/*     */       
/* 223 */       if (titulo.getParametrosBancarios().contemComNome((ParametroBancario)ParametroBancoob.NUMERO_DA_PARCELA)) {
/* 224 */         checkParametroBancario(titulo, (ParametroBancario<?>)ParametroBancoob.NUMERO_DA_PARCELA);
/* 225 */         numeroDaParcela = (Integer)titulo.getParametrosBancarios().getValor((ParametroBancario)ParametroBancoob.NUMERO_DA_PARCELA);
/*     */       } 
/*     */     } 
/*     */     
/* 229 */     add((Field)new FixedField(titulo.getContaBancaria().getCarteira().getCodigo(), CARTEIRA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 230 */     add((Field)new FixedField(titulo.getContaBancaria().getAgencia().getCodigo(), AGENCIA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 231 */     add((Field)new FixedField(codigoDaModalidadeDeCobranca, MODALIDADE_DE_COBRANCA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 232 */     add((Field)new FixedField(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), CONTA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 233 */     add((Field)new FixedField(titulo.getContaBancaria().getNumeroDaConta().getDigitoDaConta(), DV_CONTA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 234 */     add((Field)new FixedField(titulo.getNossoNumero(), NOSSO_NUMERO_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 235 */     add((Field)new FixedField(titulo.getDigitoDoNossoNumero(), DV_NOSSO_NUMERO_LENGTH));
/* 236 */     add((Field)new FixedField(numeroDaParcela, NUMERO_DA_PARCELA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLBancoobCobrancaNaoRegistrada.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */