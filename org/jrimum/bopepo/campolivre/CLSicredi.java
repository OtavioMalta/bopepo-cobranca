/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import org.jrimum.bopepo.parametro.ParametroBancoSicredi;
/*     */ import org.jrimum.domkee.financeiro.banco.ParametroBancario;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ import org.jrimum.texgit.type.Field;
/*     */ import org.jrimum.texgit.type.Filler;
/*     */ import org.jrimum.texgit.type.component.Fillers;
/*     */ import org.jrimum.texgit.type.component.FixedField;
/*     */ import org.jrimum.utilix.Objects;
/*     */ import org.jrimum.vallia.digitoverificador.Modulo;
/*     */ import org.jrimum.vallia.digitoverificador.TipoDeModulo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CLSicredi
/*     */   extends AbstractCLSicredi
/*     */ {
/*     */   private static final long serialVersionUID = 7697120719706717353L;
/* 139 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(10);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String COBRANCA_COM_REGISTRO = "1";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String COBRANCA_SEM_REGISTRO = "3";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 154 */   private static final Integer CARTEIRA_SIMPLES_VALUE = Integer.valueOf(1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 159 */   private static final FixedField<Integer> FIELD_CARTEIRA = new FixedField(CARTEIRA_SIMPLES_VALUE, Integer.valueOf(1));
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 164 */   private static final Modulo modulo11 = new Modulo(TipoDeModulo.MODULO11);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CLSicredi() {
/* 173 */     super(FIELDS_LENGTH);
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
/* 184 */     checkCarteiraNotNull(titulo);
/* 185 */     checkCodigoDaCarteira(titulo);
/* 186 */     checkCarteiraSimples(titulo);
/* 187 */     checkRegistroDaCarteiraNotNull(titulo);
/* 188 */     checkNossoNumero(titulo);
/* 189 */     checkTamanhoDoNossoNumero(titulo, 8);
/* 190 */     checkDigitoDoNossoNumero(titulo);
/* 191 */     checkTamanhoDigitoDoNossoNumero(titulo, 1);
/* 192 */     checkCodigoDaAgencia(titulo);
/* 193 */     checkCodigoDaAgenciaMenorOuIgualQue(titulo, 99999);
/* 194 */     checkParametroBancario(titulo, (ParametroBancario<?>)ParametroBancoSicredi.POSTO_DA_AGENCIA);
/* 195 */     checkNumeroDaContaNotNull(titulo);
/* 196 */     checkCodigoDoNumeroDaConta(titulo);
/* 197 */     checkCodigoDoNumeroDaContaMenorOuIgualQue(titulo, 99999);
/* 198 */     checkValor(titulo);
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
/* 209 */     if (titulo.getContaBancaria().getCarteira().isComRegistro()) {
/*     */       
/* 211 */       add((Field)new FixedField("1", Integer.valueOf(1)));
/*     */     }
/*     */     else {
/*     */       
/* 215 */       add((Field)new FixedField("3", Integer.valueOf(1)));
/*     */     } 
/*     */     
/* 218 */     add((Field)FIELD_CARTEIRA);
/* 219 */     add((Field)new FixedField(titulo.getNossoNumero(), Integer.valueOf(8), (Filler)Fillers.ZERO_LEFT));
/* 220 */     add((Field)new FixedField(titulo.getDigitoDoNossoNumero(), Integer.valueOf(1), (Filler)Fillers.ZERO_LEFT));
/* 221 */     add((Field)new FixedField(titulo.getContaBancaria().getAgencia().getCodigo(), Integer.valueOf(4), (Filler)Fillers.ZERO_LEFT));
/* 222 */     add((Field)new FixedField(titulo.getParametrosBancarios().getValor((ParametroBancario)ParametroBancoSicredi.POSTO_DA_AGENCIA), Integer.valueOf(2), (Filler)Fillers.ZERO_LEFT));
/* 223 */     add((Field)new FixedField(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), Integer.valueOf(5), (Filler)Fillers.ZERO_LEFT));
/*     */     
/* 225 */     if (titulo.getValor().compareTo(BigDecimal.ZERO) == 1) {
/*     */       
/* 227 */       add((Field)new FixedField("1", Integer.valueOf(1)));
/*     */     }
/*     */     else {
/*     */       
/* 231 */       add((Field)new FixedField("0", Integer.valueOf(1)));
/*     */     } 
/*     */     
/* 234 */     add((Field)new FixedField("0", Integer.valueOf(1)));
/* 235 */     add((Field)new FixedField(calculeDigitoVerificador(), Integer.valueOf(1)));
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
/*     */   private void checkCarteiraSimples(Titulo titulo) {
/* 247 */     Objects.checkArgument(titulo.getContaBancaria().getCarteira().getCodigo().equals(CARTEIRA_SIMPLES_VALUE), String.format("Apenas a carteira de código [1] \"carteira simples\" é permitida e não o código [%s]!", new Object[] { titulo.getContaBancaria().getCarteira().getCodigo() }));
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
/*     */   private Integer calculeDigitoVerificador() {
/* 264 */     int resto = modulo11.calcule(writeFields());
/*     */     
/* 266 */     if (resto == 0 || resto == 1)
/*     */     {
/* 268 */       return Integer.valueOf(0);
/*     */     }
/*     */ 
/*     */     
/* 272 */     return Integer.valueOf(modulo11.valor() - resto);
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLSicredi.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */