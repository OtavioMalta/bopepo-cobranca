/*     */ package org.jrimum.bopepo.campolivre;
/*     */ 
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
/*     */ class CLItauComCarteirasEspeciais
/*     */   extends AbstractCLItau
/*     */ {
/*     */   private static final long serialVersionUID = -1532454262023154419L;
/* 119 */   private static final Integer FIELDS_LENGTH = Integer.valueOf(6);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CLItauComCarteirasEspeciais(Titulo titulo) {
/* 129 */     super(FIELDS_LENGTH);
/*     */     
/* 131 */     ContaBancaria conta = titulo.getContaBancaria();
/*     */     
/* 133 */     add((Field)new FixedField(conta.getCarteira().getCodigo(), Integer.valueOf(3), (Filler)Fillers.ZERO_LEFT));
/* 134 */     add((Field)new FixedField(titulo.getNossoNumero(), Integer.valueOf(8), (Filler)Fillers.ZERO_LEFT));
/* 135 */     add((Field)new FixedField(titulo.getNumeroDoDocumento(), Integer.valueOf(7), (Filler)Fillers.ZERO_LEFT));
/*     */ 
/*     */     
/* 138 */     add((Field)new FixedField(conta.getNumeroDaConta().getCodigoDaConta(), Integer.valueOf(5), (Filler)Fillers.ZERO_LEFT));
/*     */     
/* 140 */     add((Field)new FixedField(calculeDigitoDoCampoLivreEspecial(conta.getCarteira().getCodigo(), titulo.getNossoNumero(), titulo.getNumeroDoDocumento(), conta.getNumeroDaConta().getCodigoDaConta()), Integer.valueOf(1)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 145 */     add((Field)new FixedField(Integer.valueOf(0), Integer.valueOf(1)));
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
/*     */   private Integer calculeDigitoDoCampoLivreEspecial(Integer codigoDaCarteira, String nossoNumero, String numeroDoDocumento, Integer codigoDaConta) {
/* 164 */     StringBuilder campo = new StringBuilder();
/*     */     
/* 166 */     campo.append(Fillers.ZERO_LEFT.fill(codigoDaCarteira.intValue(), 3));
/* 167 */     campo.append(Fillers.ZERO_LEFT.fill(nossoNumero, 8));
/* 168 */     campo.append(Fillers.ZERO_LEFT.fill(numeroDoDocumento, 7));
/* 169 */     campo.append(Fillers.ZERO_LEFT.fill(codigoDaConta, 5));
/*     */     
/* 171 */     return calculeDigitoVerificador(campo.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addFields(Titulo titulo) {
/* 177 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkValues(Titulo titulo) {
/* 183 */     Exceptions.throwUnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
/*     */   }
/*     */ }


/* Location:              C:\Users\Otavio\.m2\repository\jrimum\bopepo\0.2.3\bopepo-0.2.3.jar!\org\jrimum\bopepo\campolivre\CLItauComCarteirasEspeciais.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */