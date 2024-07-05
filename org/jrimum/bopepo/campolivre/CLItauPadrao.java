/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
/*     */ import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/*     */ import org.jrimum.texgit.type.Field;
/*     */ import org.jrimum.texgit.type.Filler;
/*     */ import org.jrimum.texgit.type.component.Fillers;
/*     */ import org.jrimum.texgit.type.component.FixedField;
/*     */ import org.jrimum.utilix.Exceptions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CLItauPadrao
/*     */   extends AbstractCLItau
/*     */ {
/*     */   private static final long serialVersionUID = 1544486299245786533L;
/* 126 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(7);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CLItauPadrao(Titulo titulo) {
/* 135 */     super(FIELDS_LENGTH);
/*     */     
/* 137 */     ContaBancaria conta = titulo.getContaBancaria();
/*     */     
/* 139 */     add((Field)new FixedField(conta.getCarteira().getCodigo(), Integer.valueOf(3), (Filler)Fillers.ZERO_LEFT));
/* 140 */     add((Field)new FixedField(titulo.getNossoNumero(), Integer.valueOf(8), (Filler)Fillers.ZERO_LEFT));
/*     */     
/* 142 */     add((Field)new FixedField(calculeDigitoDaPosicao31(conta.getAgencia().getCodigo(), conta.getNumeroDaConta().getCodigoDaConta(), conta.getCarteira().getCodigo(), titulo.getNossoNumero()), Integer.valueOf(1)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 148 */     add((Field)new FixedField(conta.getAgencia().getCodigo(), Integer.valueOf(4), (Filler)Fillers.ZERO_LEFT));
/* 149 */     add((Field)new FixedField(conta.getNumeroDaConta().getCodigoDaConta(), Integer.valueOf(5), (Filler)Fillers.ZERO_LEFT));
/*     */     
/* 151 */     add((Field)new FixedField(calculeDigitoDaPosicao41(conta.getAgencia().getCodigo(), conta.getNumeroDaConta().getCodigoDaConta()), Integer.valueOf(1)));
/*     */ 
/*     */ 
/*     */     
/* 155 */     add((Field)new FixedField("000", Integer.valueOf(3)));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Integer calculeDigitoDaPosicao31(Integer codigoDaAgencia, Integer codigoDaConta, Integer codigoDaCarteira, String nossoNumero) {
/* 220 */     Integer[] carteirasEscriturais = { Integer.valueOf(104), Integer.valueOf(105), Integer.valueOf(112), Integer.valueOf(113), Integer.valueOf(114), Integer.valueOf(147), Integer.valueOf(166), Integer.valueOf(212) };
/* 221 */     Integer[] carteirasModalidadeDireta = { Integer.valueOf(126), Integer.valueOf(131), Integer.valueOf(146), Integer.valueOf(150), Integer.valueOf(168) };
/*     */     
/* 223 */     StringBuilder campo = new StringBuilder();
/* 224 */     campo.append(Fillers.ZERO_LEFT.fill(codigoDaCarteira.intValue(), 3));
/* 225 */     campo.append(Fillers.ZERO_LEFT.fill(nossoNumero, 8));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 232 */     if (Arrays.binarySearch((Object[])carteirasModalidadeDireta, codigoDaCarteira) < 0 && Arrays.binarySearch((Object[])carteirasEscriturais, codigoDaCarteira) < 0) {
/*     */ 
/*     */       
/* 235 */       campo.insert(0, Fillers.ZERO_LEFT.fill(codigoDaConta.intValue(), 5));
/* 236 */       campo.insert(0, Fillers.ZERO_LEFT.fill(codigoDaAgencia.intValue(), 4));
/*     */     } 
/*     */     
/* 239 */     return calculeDigitoVerificador(campo.toString());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Integer calculeDigitoDaPosicao41(Integer codigoDaAgencia, Integer codigoDaConta) {
/* 278 */     StringBuilder campo = new StringBuilder();
/* 279 */     campo.append(Fillers.ZERO_LEFT.fill(codigoDaAgencia.intValue(), 4));
/* 280 */     campo.append(Fillers.ZERO_LEFT.fill(codigoDaConta.intValue(), 5));
/*     */     
/* 282 */     return calculeDigitoVerificador(campo.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 288 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 294 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLItauPadrao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */