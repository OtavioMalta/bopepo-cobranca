/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import org.jrimum.bopepo.parametro.ParametroBancoDeBrasilia;
/*     */ import org.jrimum.domkee.financeiro.banco.ParametroBancario;
/*     */ import org.jrimum.domkee.financeiro.banco.ParametrosBancariosMap;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ import org.jrimum.texgit.type.Field;
/*     */ import org.jrimum.texgit.type.Filler;
/*     */ import org.jrimum.texgit.type.component.Fillers;
/*     */ import org.jrimum.texgit.type.component.FixedField;
/*     */ import org.jrimum.utilix.Objects;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CLBancoDeBrasilia
/*     */   extends AbstractCLBancoDeBrasilia
/*     */ {
/*     */   private static final long serialVersionUID = -6099168685425835517L;
/* 141 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(8);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 146 */   private static final Integer CAMPO_ZERADO_LENGTH = Integer.valueOf(3);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String CAMPO_ZERADO_VALUE = "000";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 156 */   private static final Integer AGENCIA_LENGTH = Integer.valueOf(3);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 161 */   private static final Integer CONTA_LENGTH = Integer.valueOf(7);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 166 */   private static final Integer NOSSO_NUMERO_LENGTH = Integer.valueOf(6);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 171 */   private static final Integer CARTEIRA_LENGTH = Integer.valueOf(1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 176 */   private static final Integer DIGITO_CHAVE_ASBACE_LENGTH = Integer.valueOf(1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 181 */   private static final Integer BANCO_LENGTH = Integer.valueOf(3);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 186 */   private static final Integer CARTEIRA_SEM_REGISTRO = Integer.valueOf(1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 191 */   private static final Integer CARTEIRA_COM_REGISTRO = Integer.valueOf(2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Integer digitoVerificador1DaChaveASBACE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Integer digitoVerificador2DaChaveASBACE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CLBancoDeBrasilia() {
/* 211 */     super(FIELDS_LENGTH);
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
/*     */   protected void checkValues(Titulo titulo) {
/* 224 */     checkAgenciaNotNull(titulo);
/* 225 */     checkCodigoDaAgencia(titulo);
/* 226 */     checkCodigoDaAgenciaMenorOuIgualQue(titulo, 999);
/* 227 */     checkNumeroDaContaNotNull(titulo);
/* 228 */     checkCodigoDoNumeroDaConta(titulo);
/* 229 */     checkCodigoDoNumeroDaContaMenorOuIgualQue(titulo, 9999999);
/* 230 */     checkNossoNumero(titulo);
/* 231 */     checkTamanhoDoNossoNumero(titulo, 6);
/* 232 */     checkCarteiraNotNull(titulo);
/* 233 */     checkCodigoDaCarteira(titulo);
/* 234 */     checkCarteiraComOuSemRegistro(titulo);
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
/*     */   protected void addFields(Titulo titulo) {
/* 247 */     add((Field)new FixedField("000", CAMPO_ZERADO_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 248 */     add((Field)new FixedField(titulo.getContaBancaria().getAgencia().getCodigo(), AGENCIA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 249 */     add((Field)new FixedField(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), CONTA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 250 */     add((Field)new FixedField(titulo.getContaBancaria().getCarteira().getCodigo(), CARTEIRA_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 251 */     add((Field)new FixedField(titulo.getNossoNumero(), NOSSO_NUMERO_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 252 */     add((Field)new FixedField(titulo.getContaBancaria().getBanco().getCodigoDeCompensacaoBACEN().getCodigo(), BANCO_LENGTH, (Filler)Fillers.ZERO_LEFT));
/* 253 */     calculeDigitosNecessariosDaChaveASBACE();
/* 254 */     add((Field)new FixedField(this.digitoVerificador1DaChaveASBACE, DIGITO_CHAVE_ASBACE_LENGTH));
/* 255 */     add((Field)new FixedField(this.digitoVerificador2DaChaveASBACE, DIGITO_CHAVE_ASBACE_LENGTH));
/*     */     
/* 257 */     disponibilizeDigitosDaChaveAsbaceNeste(titulo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void calculeDigitosNecessariosDaChaveASBACE() {
/* 266 */     calculeChaveAsbaceDigito1();
/* 267 */     calculeChaveAsbaceDigito2();
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
/*     */   private void calculeChaveAsbaceDigito1() {
/* 279 */     String chaveAasbace = writeFields();
/*     */     
/* 281 */     int dig = Modulo.calculeMod10(chaveAasbace, 1, 2);
/*     */     
/* 283 */     if (dig == 0) {
/* 284 */       this.digitoVerificador1DaChaveASBACE = Integer.valueOf(dig);
/*     */     } else {
/* 286 */       this.digitoVerificador1DaChaveASBACE = Integer.valueOf(10 - dig);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void calculeChaveAsbaceDigito2() {
/* 296 */     String chaveAasbaceComDv1 = writeFields() + this.digitoVerificador1DaChaveASBACE;
/*     */     
/* 298 */     int digito2 = Modulo.calculeMod11(chaveAasbaceComDv1, 2, 7);
/*     */     
/* 300 */     if (digito2 == 0) {
/* 301 */       this.digitoVerificador2DaChaveASBACE = Integer.valueOf(digito2);
/*     */     
/*     */     }
/* 304 */     else if (digito2 != 1) {
/* 305 */       this.digitoVerificador2DaChaveASBACE = Integer.valueOf(11 - digito2);
/*     */     } else {
/*     */       
/* 308 */       int digito1Recalculado = this.digitoVerificador1DaChaveASBACE.intValue() + 1;
/*     */       
/* 310 */       this.digitoVerificador1DaChaveASBACE = Integer.valueOf((digito1Recalculado == 10) ? 0 : digito1Recalculado);
/*     */       
/* 312 */       calculeChaveAsbaceDigito2();
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
/*     */   private void disponibilizeDigitosDaChaveAsbaceNeste(Titulo titulo) {
/* 327 */     ParametrosBancariosMap parametrosBancarios = titulo.getParametrosBancarios();
/*     */     
/* 329 */     if (parametrosBancarios == null) {
/* 330 */       parametrosBancarios = new ParametrosBancariosMap();
/*     */     }
/*     */     
/* 333 */     parametrosBancarios.adicione((ParametroBancario)ParametroBancoDeBrasilia.CHAVE_ASBACE_DIGITO1, this.digitoVerificador1DaChaveASBACE);
/* 334 */     parametrosBancarios.adicione((ParametroBancario)ParametroBancoDeBrasilia.CHAVE_ASBACE_DIGITO2, this.digitoVerificador2DaChaveASBACE);
/*     */     
/* 336 */     titulo.setParametrosBancarios(parametrosBancarios);
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
/*     */   private void checkCarteiraComOuSemRegistro(Titulo titulo) {
/* 352 */     Integer codigoCarteira = titulo.getContaBancaria().getCarteira().getCodigo();
/*     */     
/* 354 */     boolean carteiraValida = (codigoCarteira.equals(CARTEIRA_SEM_REGISTRO) || codigoCarteira.equals(CARTEIRA_COM_REGISTRO));
/*     */     
/* 356 */     Objects.checkArgument(carteiraValida, String.format("Código da carteira deve ser \"1-Sem registro impressão local\" ou  \"2-Com registro impressão local\" e não [%s].", new Object[] { titulo.getContaBancaria().getCarteira().getCodigo() }));
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLBancoDeBrasilia.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */